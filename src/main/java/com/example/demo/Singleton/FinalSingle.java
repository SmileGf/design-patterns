package com.example.demo.Singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 登记式/静态内部类
 * Lazy 加载方式
 * 线程安全
 * @author gf
 * @date 2021/8/23
 */
@Slf4j
public class FinalSingle {

    private static class  SingletonHolder {
         private static final FinalSingle INSTANCE = new FinalSingle();
    }

    private FinalSingle(){}

    public static FinalSingle getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public void getMessage(String message){
        log.info("------ FinalSingle : {} ------",message);
    }
}
