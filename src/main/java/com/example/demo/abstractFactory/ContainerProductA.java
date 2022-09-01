package com.example.demo.abstractFactory;
/**
 * 创建具体产品类（继承抽象产品类）， 定义生产的具体产品
 * @author gf
 * @date 2022/9/1
 */
public class ContainerProductA extends ContainerProduct {
    @Override
    public void show() {
        System.out.println("生产出了容器产品A");
    }
}
