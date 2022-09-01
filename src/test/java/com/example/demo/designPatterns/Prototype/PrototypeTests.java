package com.example.demo.designPatterns.Prototype;

import com.example.demo.prototype.Prototype;
import com.example.demo.prototype.SerializableObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * 原型设计模式 测试类
 * @author gf
 * @date 2022/8/31
 */
public class PrototypeTests {

    @Test
    public void prototypeTest() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        SerializableObject serializableObject = new SerializableObject("男");

        Prototype prototype = new Prototype("prototype",11,serializableObject);
        Prototype clone = prototype.clone();
        System.out.println("clone: " + clone);
        System.out.println("clone data: " + prototype);
        System.out.println("hash code: " + clone.hashCode());
        System.out.println("object："+ (prototype == clone));

        Prototype deepClone = prototype.deepClone();
        System.out.println("deepClone: " + deepClone);
        System.out.println("deepClone data: " + deepClone);
        System.out.println("hash code: " + deepClone.hashCode());
        System.out.println("object："+ (prototype == deepClone));

        serializableObject.setSex("女");

        System.out.println("clone: " +clone);
        System.out.println("data: "+prototype);
        System.out.println("hash code: " + clone.hashCode());
        System.out.println("object："+ (prototype == clone));

        System.out.println("deepClone: " + deepClone);
        System.out.println("deepClone data: " + deepClone);
        System.out.println("hash code: " + deepClone.hashCode());
        System.out.println("object："+ (prototype == deepClone));



    }
}
