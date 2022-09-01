package com.example.demo.Singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉式  单例
 * 优点：没有加锁 执行效率提高
 * 缺点：类加载时就初始化 浪费内存
 * @author gf
 * @date 2021/8/19
 */
@Slf4j
public class SimpleSingle {

    /**
     * 创建 T 的 一个对象
     */
    private static SimpleSingle simpleSingle =  new SimpleSingle();

    /**
     * 私有化构造函数 这样该类就不会被实例化
     */
    private SimpleSingle(){

    }

    /**
     * 获取唯一可用的对象
     * @return T
     */
    public static SimpleSingle getInstance(){
        return simpleSingle;
    }

    public void getMessage(String message){
      log.info("------ SimpleSingle : {} ------",message);
    }
}
