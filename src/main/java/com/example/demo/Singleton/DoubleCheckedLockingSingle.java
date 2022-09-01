package com.example.demo.Singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 双锁式 单例模式
 * lazy 加载方式
 * 线程 安全
 * @author gf
 * @date 2021/8/19
 */
@Slf4j
public class DoubleCheckedLockingSingle {

    private static volatile DoubleCheckedLockingSingle  instance;

    private DoubleCheckedLockingSingle(){}

    public static DoubleCheckedLockingSingle getInstance(){
        if(instance == null){
            synchronized (DoubleCheckedLockingSingle.class){
                if(instance == null){
                    instance = new DoubleCheckedLockingSingle();
                }
            }
        }
        return instance;
    }

    public void getMessage(String message){
        log.info("------ DoubleCheckedLockingSingle : {} ------",message);
    }
}
