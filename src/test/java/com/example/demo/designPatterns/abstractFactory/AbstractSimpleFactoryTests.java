package com.example.demo.designPatterns.abstractFactory;

import com.example.demo.abstractFactory.AbstractFactoryInterface;
import com.example.demo.abstractFactory.FactoryA;
import com.example.demo.abstractFactory.FactoryB;
import org.junit.jupiter.api.Test;

/**
 * Abstract Factory test
 * 抽象类工厂与工厂方法区别
 *  工厂方法模式只有一个抽象产品类,而抽象工厂有多个
 *  工厂方法模式的具体工厂类只能创建一个具体产品类的实例,而抽象工厂模式可以创建多个.
 *  工厂方法模式： 一个抽象产品类，可以派生出多个具体产品类。 一个抽象工厂类，可以派生出多个具体工厂类。 每个具体工厂类只能创建一个具体产品类的实例。
 *  抽象工厂模式： 多个抽象产品类，每个抽象产品类可以派生出多个具体产品类。 一个抽象工厂类，可以派生出多个具体工厂类。
 *  每个具体工厂类可以创建多个具体产品类的实例。
 *  区别： 工厂方法模式只有一个抽象产品类，而抽象工厂模式有多个。
 *  工厂方法模式的具体工厂类只能创建一个具体产品类的实例，而抽象工厂模式可以创建多个。
 * @author gf
 * @date 2022/8/31
 */
public class AbstractSimpleFactoryTests {

    /**
     * 抽象类工厂
     * 其实这个模式的好处就是，如果你现在想增加一个功能：只需做一个实现类，实现processHandler接口，
     * 同时做一个工厂类，实现AbstractFactoryInterface接口，就OK了，无需去改动现成的代码。这样做，拓展性较好！
     */
    @Test
    public void abstractFactoryTest(){
        AbstractFactoryInterface factoryA = new FactoryA();
        factoryA.manufactureContainer().show();
        factoryA.manufactureMould().show();

        AbstractFactoryInterface factoryB = new FactoryB();
        factoryB.manufactureContainer().show();
        factoryB.manufactureMould().show();
    }
}
