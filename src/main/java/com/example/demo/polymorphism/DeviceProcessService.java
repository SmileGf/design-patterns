package com.example.demo.polymorphism;

import org.springframework.stereotype.Component;

/**
 * @author gongguifang
 */
@Component
public class DeviceProcessService implements ProcessServices {

    /**
     * process handler
     *
     */
    @Override
    public void processHandler() {
        System.out.println("Device Process Service Handler");
    }
}
