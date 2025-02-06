package com.jarvis.springbootappcache.model;

import org.springframework.stereotype.Component;

@Component
public class Bus implements Vehicle {

    @Override
    public String getName() {
        return "BUS";
    }

    @Override
    public void move(){
        System.out.println("Bus is moving");
    }

}
