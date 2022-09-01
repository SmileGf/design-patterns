package com.example.demo.util;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.JarURLConnection;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/**
 * class util
 * @author gf
 * @date 2022/8/30
 */
public class ClassUtil {

    /**
     * 类后缀名
     */
    private static final String  CLASS_SUFFIX = ".class";


    /**
     * 根据类接口查到所有的class
     * @param clazz 接口文件
     * @return class
     */
    public static List<Class<?>> getAllClassByInterface(Class<?> clazz){
        List<Class<?>> list = new ArrayList<>();
        List<Class<?>> allClass = getAllClass(clazz.getPackage().getName());
        // 循环判断路径下的所有类是否实现了指定的接口 并且排除接口类自己
        for(Class<?> c : allClass){
            if(clazz.isAssignableFrom(c)){
                if(!clazz.equals(c)){
                    //自身并不加入
                    list.add(c);
                }
            }
        }
        return list;
    }





    /**
     * 根据类接口查到所有的class
     * @param clazz 接口文件
     * @return class
     */
    public static List<Class<?>> getAllClassByAnnotation(Class<? extends Annotation> clazz) {
        List<Class<?>> allClass = getAllClass(clazz.getPackage().getName());
        return allClass.stream().filter((a)->a.isAnnotationPresent(clazz)).collect(Collectors.toList());
    }

    /**
     * 根据类接口查到所有的class(指定包名)
     * @param clazz 接口文件
     * @return class
     */
    public static List<Class<?>> getAllClassByAnnotation(Class<? extends Annotation> clazz, String packageName) {
        List<Class<?>> allClass = getAllClass(packageName);
        return allClass.stream().filter((a) -> a.isAnnotationPresent(clazz)).collect(Collectors.toList());
    }

    /**
     * 从指定路径下查找所有的类
     * @param packageName 包路径
     * @return 所有类名的集合
     */
    private static List<Class<?>> getAllClass(String packageName) {
        List<String> classNameList = getClassPathsByPackage(packageName);
        return classNameList.stream().map((b) -> {
            try {
                return Class.forName(b);
            } catch (ClassNotFoundException e) {
                return null;
            }
        }).filter(Objects::nonNull).distinct().collect(Collectors.toList());
    }

    /**
     * 获取包下所有的类
     * @param packageName 包名
     * @return 所有类名集合
     */
    public static List<String> getClassPathsByPackage(String packageName){
        List<String> fileNames = new ArrayList<>() ;
        // class loader context
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        // 包路径
        String packagePath = packageName.replace(".", "/");
        URL url = loader.getResource(packagePath);
        if(url != null){
            String type = url.getProtocol();
            if("file".equals(type)){
                String fileSearchPath = url.getPath();
                fileSearchPath = fileSearchPath.substring(0, fileSearchPath.indexOf("/classes"));
                fileNames = getClassPathsByFile(fileSearchPath);
            }else if("jar".equals(type)){
                try{
                    JarURLConnection jarUrlConnection = (JarURLConnection)url.openConnection();
                    JarFile jarFile = jarUrlConnection.getJarFile();
                    fileNames = getClassPathsByJar(jarFile);
                }catch (IOException e){
                    throw new RuntimeException("open Package URL failed："+e.getMessage());
                }
            }else {

                throw new RuntimeException("file system not support! cannot load MsgProcessor！");
            }
        }
        return fileNames;
    }


    /**
     * 从项目文件获取某包下所有类
     * @param filePath 文件路径
     * @return 类的完整名称
     */
    private static List<String> getClassPathsByFile(String filePath) {
        List<String> classPaths = new ArrayList<>();

        try{
            Files.walkFileTree(Paths.get(new File(filePath).getAbsolutePath()),new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
                    String filePath = file.toFile().getPath();
                    if(filePath.endsWith(CLASS_SUFFIX)){
                        filePath = filePath.substring(filePath.indexOf(File.separator+"classes") + 9, filePath.lastIndexOf("."));
                        filePath = filePath.replace(File.separator, ".").replace("/",".").replace("\\",".");
                        classPaths.add(filePath);
                    }
                    return  super.visitFile(file,attrs);
                }
            });
        }catch (IOException e){
            throw new RuntimeException("walk files error!",e);
        }
        return classPaths;
    }


    /**
     * 从jar获取某包下所有类
     * @return 类的完整名称
     */
    private static List<String> getClassPathsByJar(JarFile jarFile) {
        List<String> classNames = new ArrayList<>();
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()){
            JarEntry jarEntry = entries.nextElement();
            String entryName = jarEntry.getName();
            if(entryName.endsWith(CLASS_SUFFIX)){
                entryName  = entryName.replace(File.separator, ".").replace("/", ".")
                        .replace("\\", ".").substring(0, entryName.lastIndexOf("."));
                classNames.add(entryName);
            }
        }
        return classNames;
    }
}
