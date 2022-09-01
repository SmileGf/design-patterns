package com.example.demo.Singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 单例 懒汉式 线程不安全 多线程情况下不能使用
 * @author gf
 * @date 2021/8/19
 */
@Slf4j
public class LazyThreadNoSafeSingle {

    private static LazyThreadNoSafeSingle lazyThreadNoSafeSingle;

    private  LazyThreadNoSafeSingle(){}

    public static LazyThreadNoSafeSingle getInstance(){
        if(lazyThreadNoSafeSingle == null){
            lazyThreadNoSafeSingle = new LazyThreadNoSafeSingle();
        }
        return lazyThreadNoSafeSingle;
    }

    public void getMessage(String message){
        log.info("------ LazyThreadNoSafeSingle : {} ------",message);
    }

}
