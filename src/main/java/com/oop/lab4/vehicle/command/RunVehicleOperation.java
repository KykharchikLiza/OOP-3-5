package com.oop.lab4.vehicle.command;

import com.oop.lab4.vehicle.Vehicle;

public class RunVehicleOperation implements VehicleOperation{

    private final Vehicle vehicle;

    public RunVehicleOperation(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String execute() {
        return vehicle.move();
    }
}
