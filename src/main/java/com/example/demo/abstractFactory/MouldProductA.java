package com.example.demo.abstractFactory;
/**
 * 创建具体产品类（继承抽象产品类）， 定义生产的具体产品；
 * @author gf
 * @date 2022/9/1
 */
public class MouldProductA extends MouldProduct {
    @Override
    public void show() {
        System.out.println("生产出了模具产品A");
    }
}
