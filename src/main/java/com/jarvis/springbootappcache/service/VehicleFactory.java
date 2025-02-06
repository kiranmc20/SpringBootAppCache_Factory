package com.jarvis.springbootappcache.service;


import com.jarvis.springbootappcache.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class VehicleFactory {

    private final Map<String, Vehicle> vehiclesMap;

    public VehicleFactory(Set<Vehicle> vehicles){
        vehiclesMap = Collections.unmodifiableMap(vehicles.stream()
                .collect(Collectors
                        .toMap(Vehicle::getName, Function.identity())));
    }

    public Vehicle getVehicleInstance(VehicleProvider vehicleProvider){
        return vehiclesMap.get(vehicleProvider.getName());
    }
}
