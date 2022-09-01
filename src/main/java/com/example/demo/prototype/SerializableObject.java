package com.example.demo.prototype;

import java.io.Serializable;
/**
 *  Serializable Object
 * @author gf
 * @date 2022/8/31
 */
public class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sex;

    public SerializableObject() {
    }

    public SerializableObject(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "SerializableObject{" +
                "sex='" + sex + '\'' +
                '}';
    }
}
