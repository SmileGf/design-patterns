package com.example.demo.designPatterns.factoryMethod;

import com.example.demo.factoryMethod.AgvProcessFactoryMethod;
import com.example.demo.factoryMethod.DeviceProcessFactoryMethod;
import com.example.demo.factoryMethod.FactoryMethod;
import com.example.demo.factoryMethod.HoistProcessFactoryMethod;
import org.junit.jupiter.api.Test;

/**
 * factory method tests
 * @author gf
 * @date 2022/8/31
 */
public class FactoryMethodTests {

    /**
     * 工厂方法模式
     */
    @Test
    public void manyMethodsFactoryTest(){
        FactoryMethod factoryMethod = new AgvProcessFactoryMethod();
        factoryMethod.manufacture().processHandler();

        FactoryMethod deviceFactoryMethod = new DeviceProcessFactoryMethod();
        deviceFactoryMethod.manufacture().processHandler();

        FactoryMethod HoistFactoryMethod = new HoistProcessFactoryMethod();
        HoistFactoryMethod.manufacture().processHandler();
    }

}
