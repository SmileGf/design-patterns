package com.example.demo.prototype;

import java.io.*;

/**
 *  原型模式
 *  原型模式的思想就是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象
 *
 *  浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 *
 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
 * @author gf
 * @date 2022/8/31
 */
public class Prototype implements Cloneable , Serializable {

    private static final long serialVersionUID = 1L;

    public Prototype(){
    }

    public Prototype(String name ,int age,SerializableObject obj){
        this.name = name;
        this.age = age;
        this.obj = obj;
    }

    private String name;

    private int age;

    private SerializableObject obj;


    /**
     * 浅复制
     * @return prototype
     * @throws CloneNotSupportedException exception
     */
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }

    /**
     * 深复制
     * @return object
     * @throws IOException ioException
     * @throws ClassNotFoundException class not found exception
     */
    public Prototype deepClone() throws IOException, ClassNotFoundException {

        // 写入挡墙对象的二进制流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);


        // 读出二进制流产生的新对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Prototype)ois.readObject();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }


    @Override
    public String toString() {
        return "Prototype{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", obj=" + obj +
                '}';
    }
}
