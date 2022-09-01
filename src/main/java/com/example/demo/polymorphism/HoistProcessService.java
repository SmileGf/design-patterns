package com.example.demo.polymorphism;

import org.springframework.stereotype.Component;

/**
 * @author gongguifang
 */
@Component
public class HoistProcessService implements ProcessServices {
    /**
     * process handler
     */
    @Override
    public void processHandler() {
        System.out.println("Hoist Process Service Handler");
    }
}
