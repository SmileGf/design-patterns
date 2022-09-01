package com.example.demo.designPatterns.builder;

import com.example.demo.builder.Builder;
import com.example.demo.polymorphism.ProcessServices;
import org.junit.jupiter.api.Test;

public class BuilderTests {

    @Test
    public void builderTest(){
        Builder builder = new Builder();
        builder.processAgvService(1);
        builder.processDeviceService(1);
        builder.processHoistService(1);
        builder.list.forEach(ProcessServices::processHandler);

    }
}
