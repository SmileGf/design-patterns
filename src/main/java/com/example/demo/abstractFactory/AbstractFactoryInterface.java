package com.example.demo.abstractFactory;

import com.example.demo.polymorphism.ProcessServices;

/**
 * 工厂类 接口
 * @author gf
 * @date 2022/8/31
 */
public interface AbstractFactoryInterface {

    /**
     * 抽象工厂类 接口
     * @return 实例对象
     */
    ProcessServices factoryInterfaceProcess();
}
