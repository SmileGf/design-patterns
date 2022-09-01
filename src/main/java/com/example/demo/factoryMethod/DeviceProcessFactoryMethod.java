package com.example.demo.factoryMethod;

import com.example.demo.polymorphism.DeviceProcessService;
import com.example.demo.polymorphism.ProcessServices;

/**
 * device process factory method
 * @author gf
 * @date 2022/9/1
 */
public class DeviceProcessFactoryMethod implements FactoryMethod{

    @Override
    public ProcessServices manufacture() {
        return new DeviceProcessService();
    }
}
