package com.example.demo.abstractFactory;

import com.example.demo.polymorphism.HoistProcessService;
import com.example.demo.polymorphism.ProcessServices;

/**
 * hoist abstract factory 实现类
 * @author gf
 * @date 2022/8/31
 */
public class HoistAbstractFactory implements AbstractFactoryInterface{
    @Override
    public ProcessServices factoryInterfaceProcess() {
        return new HoistProcessService();
    }
}
