package com.example.demo.Singleton;

import lombok.extern.slf4j.Slf4j;
/**
 * 懒汉式 线程安全 加锁 synchronized
 * 优点：第一次调用才去初始化，避免内存浪费
 * 缺点：必须加锁 synchronized 才能保证单例 加锁会影响效率
 * @author gf
 * @date 2021/8/19
 */
@Slf4j
public class LazyThreadSafeSingle {

    private static LazyThreadSafeSingle instance;

    private LazyThreadSafeSingle(){

    }

    public static synchronized LazyThreadSafeSingle getInstance(){
        if(instance == null){
            instance = new LazyThreadSafeSingle();
        }
        return  instance;
    }

    public void getMessage(String message){
        log.info("------ LazyThreadSafeSingle : {} ------",message);
    }
}
