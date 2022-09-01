package com.example.demo.abstractFactory;

/**
 * 创建具体工厂类（继承抽象工厂类），定义创建对应具体产品实例的方法；
 * @author gf
 * @date 2022/9/1 
 */
public class FactoryA extends AbstractFactoryInterface {
    @Override
   public AbstractProduct  manufactureContainer() {
        return new ContainerProductA();
    }

    @Override
    public AbstractProduct  manufactureMould() {
        return new ContainerProductA();
    }
}
