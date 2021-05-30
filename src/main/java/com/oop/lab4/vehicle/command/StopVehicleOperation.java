package com.oop.lab4.vehicle.command;

import com.oop.lab4.vehicle.Vehicle;

public class  StopVehicleOperation implements VehicleOperation{

    private final Vehicle vehicle;

    public StopVehicleOperation(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String execute() {
        return vehicle.stop();
    }
}
