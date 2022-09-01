package com.example.demo.simpleFactory;

import com.example.demo.polymorphism.AgvProcessService;
import com.example.demo.polymorphism.DeviceProcessService;
import com.example.demo.polymorphism.HoistProcessService;
import com.example.demo.polymorphism.ProcessServices;

/**
 * 简单工厂类(静态简单工厂类)
 *  将类实例化的操作与使用对象的操作分开,让使用者不知道具体参数就可以实例化出所需的实例对象类,从而避免客户端代码中显式指定,实现解耦.
 * 优点:
 *    将创建实例的工作和使用实例的工作分开,使用者不必关心类对象如何创建,实现解耦.
 *    把初始化实例时的工作放到工厂里进行,使代码更容易维护,更符合面向对象的原则和面向接口编程.
 * 缺点:
 *    工厂类集中了所有实例的创建逻辑,一旦这个工厂不能正常工作,整个系统都会受到影响.
 *    违背"开放-关闭原则",一旦添加新实例对象不得不修改工厂类逻辑,造成工厂类过于复杂.
 *    简单工厂模式由于使用了静态工厂方法,静态方法不能被继承和重写,会造成工厂角色无法形成基于继承的等级结构.
 * @author gf
 * @date 2022/9/1
 */
public class SimpleFactory {

    private static final String AGV = "agv";

    private static final String DEVICE = "device";

    private static final String HOIST = "hoist";

    /**
     * 静态工厂方法模式，将工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
     */
    public static ProcessServices staticSimpleFactory(String type){
        switch (type){
            case AGV:
                return new AgvProcessService();
            case DEVICE:
                return new DeviceProcessService();
            case HOIST:
                return new HoistProcessService();
            default:
                return null;
        }
    }

    /**
     * 简单工厂模式 建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
     * @param type 工厂实例对象类型
     * @return 实例对象
     */
    public ProcessServices simpleProcess(String type){
        if(AGV.equals(type)){
            return new AgvProcessService();
        }else if(DEVICE.equals(type)){
            return new DeviceProcessService();
        }else if(HOIST.equals(type)){
            return  new HoistProcessService();
        }
        return null;
    }
}
