package com.example.demo.factoryMethod;

import com.example.demo.polymorphism.AgvProcessService;
import com.example.demo.polymorphism.ProcessServices;

/**
 * agv process factory method
 * @author gf
 * @date 2022/9/1
 */
public class AgvProcessFactoryMethod implements FactoryMethod{

    @Override
    public ProcessServices manufacture() {
        return new AgvProcessService();
    }
}
