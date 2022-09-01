package com.example.demo.designPatterns.Singleton;

import com.example.demo.Singleton.*;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 单例 测试类
 *
 * 一般情况下 不建议使用第一种和第二种懒汉方式 建议使用第三种饿汉方式
 *  要求使用 lazy 加载时才会使用第五种登记方式
 *  涉及到反序列化创建对象时 可以尝试第六种枚举式方式
 *  有其他特殊的需求时 可以考虑用第四种 双检锁方式
 *
 *  优点：
 *      在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例。
 *      避免对资源的多重占用。
 *  缺点：
 *      没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。
 * @author gf
 * @date 2021/8/19
 */
public class SingletonTests {

    /**
     * 懒汉式 lazy加载  线程不安全 单例
     */
    @Test
    public void lazyThreadNoSafeSingle(){
        LazyThreadNoSafeSingle lazyThreadNoSafeSingle =  LazyThreadNoSafeSingle.getInstance();
        lazyThreadNoSafeSingle.getMessage("test LazyThreadNoSafeSingle");
    }

    /**
     *  懒汉式 lazy加载 线程安全 单例 加锁
     */
    @Test
    public void lazyThreadSafeSingle(){
        LazyThreadSafeSingle lazyThreadSafeSingle = LazyThreadSafeSingle.getInstance();
        lazyThreadSafeSingle.getMessage("test LazyThreadSafeSingle");
    }

    /**
     *  饿汉式 非lazy加载 线程安全 单例模式
     */
    @Test
    public void simpleSingle(){
        SimpleSingle simpleSingle = SimpleSingle.getInstance();
        simpleSingle.getMessage("test singleton");
    }

    /**
     * 双锁式 lazy加载 线程安全 单例 加锁
     */
    @Test
    public void doubleCheckedLockingSingle(){
        DoubleCheckedLockingSingle single =  DoubleCheckedLockingSingle.getInstance();
        single.getMessage("test DoubleCheckedLockingSingle");
    }

    /**
     * 静态内部类 lazy加载 线程安全 单例
     */
    @Test
    public void finalSingle(){
        FinalSingle finalSingle = FinalSingle.getInstance();
        finalSingle.getMessage("test FinalSingle");
    }

    /**
     * 枚举 非lazy加载 线程安全  单例
     */
    @Test
    public void enumSingle(){
        EnumSingle enumSingle = EnumSingle.INSTANCE;
        enumSingle.getMessage("test EnumSingle");
    }
}
