package com.oop.lab4.vehicle.aircraft;

import com.oop.lab4.vehicle.Engine;

public class Helicopter extends AirCraft {

    private double rotorDiameter;

    public Helicopter(
            String serialNumber,
            int year,
            String brand,
            Engine engine,
            double maxTakeoffWeight,
            int maxPassengers,
            double rotorDiameter) {
        super(serialNumber, year, brand, engine, maxTakeoffWeight, maxPassengers);
        this.rotorDiameter = rotorDiameter;
    }

    public Helicopter() {
    }

    public double getRotorDiameter() {
        return rotorDiameter;
    }

    @Override
    public String toString() {
        return "Helicopter{" +
                "speed=" + speed +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", engine=" + engine +
                ", verticalSpeed=" + verticalSpeed +
                ", maxTakeoffWeight=" + maxTakeoffWeight +
                ", takeoffWeight=" + takeoffWeight +
                ", rotorDiameter=" + rotorDiameter +
                '}';
    }

    public void setRotorDiameter(double rotorDiameter) {
        this.rotorDiameter = rotorDiameter;
    }
}
