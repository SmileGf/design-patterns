package com.example.demo.builder;

import com.example.demo.polymorphism.AgvProcessService;
import com.example.demo.polymorphism.DeviceProcessService;
import com.example.demo.polymorphism.HoistProcessService;
import com.example.demo.polymorphism.ProcessServices;

import java.util.ArrayList;
import java.util.List;

/**
 * builder 建造者模式
 *  将各种产品集中起来进行管理，用来创建复合对象，所谓复合对象就是指某个类具有不同的属性，
 *  优点：
 *      产品的建造和表示分离，实现了解耦，可以使用相同的创建过程得到不同的产品。
 *      将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰。（良好的封装性，不必知道内部组成的细节）
 *      增加新的具体建造者无需修改原有类库的代码，易于拓展，符合“开闭原则“。
 *  缺点：
 *      产品必须有共同点，限制了使用范围。建造者模式创造出来的产品，其组成部分基本相同。如果产品之间的差异较大，则不适用这个模式
 *      产生多余的builder对象以及director对象，消耗内存。（如内部变化复杂，会有很多的建造类，难以维护）
 * @author gf
 * @date 2022/8/31
 */
public class Builder {

    public List<ProcessServices> list = new ArrayList<>();

    public void processAgvService(int count){
        for(int i = 0 ; i < count ;i++){
            list.add(new AgvProcessService());
        }
    }

    public void processDeviceService(int count){
        for(int i = 0 ; i < count ;i++){
            list.add(new DeviceProcessService());
        }
    }

    public void processHoistService(int count){
        for(int i = 0 ; i < count ;i++){
            list.add(new HoistProcessService());
        }
    }
}
