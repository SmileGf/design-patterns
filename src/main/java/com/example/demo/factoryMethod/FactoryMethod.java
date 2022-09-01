package com.example.demo.factoryMethod;

import com.example.demo.polymorphism.AgvProcessService;
import com.example.demo.polymorphism.DeviceProcessService;
import com.example.demo.polymorphism.HoistProcessService;
import com.example.demo.polymorphism.ProcessServices;

/**
 * 工厂模式
 * @author gf
 * @date 2022/8/31
 */
public class FactoryMethod {

    private static final String AGV = "agv";

    private static final String DEVICE = "device";

    private static final String HOIST = "hoist";

    /**
     * 普通工厂模式 建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
     * @param type 工厂实例对象类型
     * @return 实例对象
     */
    public ProcessServices ordinaryProcess(String type){
        if(AGV.equals(type)){
            return new AgvProcessService();
        }else if(DEVICE.equals(type)){
            return new DeviceProcessService();
        }else if(HOIST.equals(type)){
            return  new HoistProcessService();
        }
        return null;
    }

    /**
     *  多方法工厂模式 是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，
     *  而多个工厂方法模式是提供多个工厂方法，分别创建对象。
     */
    public ProcessServices agvProcess(){
        return new AgvProcessService();
    }

    public ProcessServices deviceProcess(){
        return new DeviceProcessService();
    }

    public ProcessServices hoistProcess(){
        return new HoistProcessService();
    }

    /**
     * 静态工厂方法模式，将工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
     */
    public static ProcessServices staticAgvProcess(){
        return new AgvProcessService();
    }

    public static ProcessServices staticDeviceProcess(){
        return new DeviceProcessService();
    }

    public static ProcessServices staticHoistProcess(){
        return new HoistProcessService();
    }
}
