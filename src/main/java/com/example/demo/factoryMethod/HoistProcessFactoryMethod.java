package com.example.demo.factoryMethod;

import com.example.demo.polymorphism.HoistProcessService;
import com.example.demo.polymorphism.ProcessServices;

/**
 * hoist process factory method
 * @author gf
 * @date 2022/9/1
 */
public class HoistProcessFactoryMethod implements FactoryMethod {
    @Override
    public ProcessServices manufacture() {
        return new HoistProcessService();
    }
}
