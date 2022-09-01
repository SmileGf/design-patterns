package com.example.demo.abstractFactory;

/**
 * 抽象工厂类 接口 定义具体工厂的公共接口
 * 优点:
 *      抽象工厂模式将具体产品的创建延迟到具体工厂的子类中,这样将对象的创建封装起来,可以减少客户端与具体产品类之间的延迟,从而降低系统耦合度更利于后启维护扩展.
 *      符合开闭原则
 *      符合单一职责原则
 *      不使用静态工厂方法，可以形成基于继承的等级结构。
 * 缺点:
 *      抽象工厂模式很难支持新种类产品的变化。
 *      这是因为抽象工厂接口中已经确定了可以被创建的产品集合，如果需要添加新产品，此时就必须去修改抽象工厂的接口，这样就涉及到抽象工厂类的以及所有子类的改变，这样也就违背了“开发——封闭”原则。
 * @author gf
 * @date 2022/8/31
 */
public abstract class AbstractFactoryInterface {

    /**
     * 抽象工厂类 Container
     * @return 实例对象
     */
    public abstract AbstractProduct  manufactureContainer();

    /**
     * 抽象工厂类 Mould
     * @return 实例对象
     */
    public abstract AbstractProduct  manufactureMould();
}
