package com.example.demo.abstractFactory;

import com.example.demo.polymorphism.AgvProcessService;
import com.example.demo.polymorphism.ProcessServices;

/**
 * agv abstract factory 实现类
 * @author gf
 * @date 2022/8/31
 */
public class AgvAbstractFactory implements  AbstractFactoryInterface{

    @Override
    public ProcessServices factoryInterfaceProcess() {
        return new AgvProcessService();
    }
}
