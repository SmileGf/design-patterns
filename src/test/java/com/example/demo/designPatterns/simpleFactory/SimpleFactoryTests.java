package com.example.demo.designPatterns.simpleFactory;

import com.example.demo.simpleFactory.SimpleFactory;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * 简单工厂 测试类
 * @author gf
 * @date 2022/9/1
 */
public class SimpleFactoryTests {


    /**
     * 静态 简单工厂方法模式，将工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
     */
    @Test
    public void staticSimpleFactoryTest(){
        Objects.requireNonNull(SimpleFactory.staticSimpleFactory("agv")).processHandler();
        Objects.requireNonNull(SimpleFactory.staticSimpleFactory("device")).processHandler();
        Objects.requireNonNull(SimpleFactory.staticSimpleFactory("hoist")).processHandler();
    }

    /**
     * 非静态 简单工厂
     */
    @Test
    public void ordinaryFactoryTest(){
        SimpleFactory simpleFactory = new SimpleFactory();
        simpleFactory.simpleProcess("agv").processHandler();
        simpleFactory.simpleProcess("device").processHandler();
        simpleFactory.simpleProcess("hoist").processHandler();
    }

}
