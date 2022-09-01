package com.example.demo.polymorphism;

import org.springframework.stereotype.Component;

/**
 * @author gongguifang
 */
@Component
public class AgvProcessService implements  ProcessServices{
    /**
     * process handler
     */
    @Override
    public void processHandler() {
        System.out.println("Agv Process Service Handler");
    }
}
