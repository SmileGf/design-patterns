package com.example.demo.Singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 枚举 单例
 * 线程安全
 * 非 lazy 加载
 * @author gf
 * @date 2021/8/23
 */
@Slf4j
public enum  EnumSingle {

    /**
     * 单例对象
     */
    INSTANCE;

    public void whateverMethod(){}

    /**
     * 单例对象方法
     * @param message message
     */
    public void getMessage(String message){
        log.info("------ EnumSingle : {} ------",message);
    }
}
