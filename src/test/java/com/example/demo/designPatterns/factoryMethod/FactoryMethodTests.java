package com.example.demo.designPatterns.factoryMethod;

import com.example.demo.factoryMethod.FactoryMethod;
import org.junit.jupiter.api.Test;

/**
 * factory method tests
 * @author gf
 * @date 2022/8/31
 */
public class FactoryMethodTests {

    /**
     * 普通 工厂
     */
    @Test
    public void ordinaryFactoryTest(){
        FactoryMethod factoryMethod = new FactoryMethod();
        factoryMethod.ordinaryProcess("agv").processHandler();
        factoryMethod.ordinaryProcess("device").processHandler();
        factoryMethod.ordinaryProcess("hoist").processHandler();
    }

    /**
     * 多方法 工厂
     */
    @Test
    public void manyMethodsFactoryTest(){
        FactoryMethod factoryMethod = new FactoryMethod();
        factoryMethod.agvProcess().processHandler();
        factoryMethod.deviceProcess().processHandler();
        factoryMethod.hoistProcess().processHandler();
    }

    /**
     * 静态方法 工厂
     */
    @Test
    public void staticMethodsFactoryTest(){
        FactoryMethod.staticAgvProcess().processHandler();
        FactoryMethod.staticDeviceProcess().processHandler();
        FactoryMethod.staticHoistProcess().processHandler();
    }
}
