package com.example.demo.abstractFactory;

import com.example.demo.polymorphism.DeviceProcessService;
import com.example.demo.polymorphism.ProcessServices;

/**
 * device abstract factory 实现类
 * @author gf
 * @date 2022/8/31
 */
public class DeviceAbstractFactory implements AbstractFactoryInterface{

    @Override
    public ProcessServices factoryInterfaceProcess() {
        return new DeviceProcessService();
    }
}
