package com.jarvis.springbootappcache.service;

public enum VehicleProvider {

    CAR("CAR"),
    BUS("BUS");

    private final String name;

    VehicleProvider(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
