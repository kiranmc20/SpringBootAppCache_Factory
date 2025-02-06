package com.jarvis.springbootappcache.model;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{

    @Override
    public String getName() {
        return "CAR";
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}
