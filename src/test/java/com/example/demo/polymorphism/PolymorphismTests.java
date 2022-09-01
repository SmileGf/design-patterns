package com.example.demo.polymorphism;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


@Slf4j
//@SpringBootTest
public class PolymorphismTests{

//    @Resource
//    List<ProcessServices> processServices;

    @Test
    public void Test() throws Exception {
        System.out.println("------------------------使用反射创建对象-------------------------------");
        // 使用反射创建对象
        Class<?> clazz = Class.forName("com.example.demo.polymorphism.AgvProcessService");
        ((ProcessServices)clazz.newInstance()).processHandler();
        printProperty("com.example.demo.polymorphism.AgvProcessService");

        System.out.println("------------------------普通-------------------------------");
        ProcessServices agv = new AgvProcessService();
        agv.processHandler();
        ProcessServices device = new DeviceProcessService();
        device.processHandler();
        ProcessServices hoist = new HoistProcessService();
        hoist.processHandler();

        System.out.println("----------------------spring ---------------------------------");
//        System.out.println(processServices);
//        processServices.forEach(ProcessServices::processHandler);
    }

    public static void printProperty(String classPath) throws Exception{
        // 解析传入路径下的类
        Class<?> clazz = Class.forName(classPath);

        // 获取字节码所有的public字段(含父类)
        Field[] fields = clazz.getFields();

        // 获取当前类的所有字段
        Field[] declaredFields = clazz.getDeclaredFields();

        // 获取当前类的所有public方法(含父类)
        Method[] methods = clazz.getMethods();

        // 获取当前类的类名
        String name = clazz.getName();

        // 获取当前类的public构造方法
        Constructor<?>[] constructors = clazz.getConstructors();

        log.info("fields: {},declaredFields: {},methods: {},name: {},constructors: {}",fields,declaredFields,methods,name,constructors);
    }
}
