package com.example.demo.designPatterns.abstractFactory;

import com.example.demo.abstractFactory.AgvAbstractFactory;
import com.example.demo.abstractFactory.DeviceAbstractFactory;
import com.example.demo.abstractFactory.HoistAbstractFactory;
import org.junit.jupiter.api.Test;

/**
 * Abstract Factory test
 * @author gf
 * @date 2022/8/31
 */
public class AbstractFactoryTests {

    /**
     * 抽象类工厂
     * 其实这个模式的好处就是，如果你现在想增加一个功能：只需做一个实现类，实现processHandler接口，
     * 同时做一个工厂类，实现AbstractFactoryInterface接口，就OK了，无需去改动现成的代码。这样做，拓展性较好！
     */
    @Test
    public void abstractFactoryTest(){
        new AgvAbstractFactory().factoryInterfaceProcess().processHandler();
        new DeviceAbstractFactory().factoryInterfaceProcess().processHandler();
        new HoistAbstractFactory().factoryInterfaceProcess().processHandler();
    }
}
