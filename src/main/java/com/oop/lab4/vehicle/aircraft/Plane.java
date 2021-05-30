package com.oop.lab4.vehicle.aircraft;

import com.oop.lab4.vehicle.Engine;

public class Plane extends AirCraft {

    private int enginesCount;

    public Plane(
            String serialNumber,
            int year,
            String brand,
            Engine engine,
            double maxTakeoffWeight,
            int maxPassengers,
            int enginesCount) {
        super(serialNumber, year, brand, engine, maxTakeoffWeight, maxPassengers);
        this.enginesCount = enginesCount;
    }

    public Plane() {
    }

    public int getEnginesCount() {
        return enginesCount;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "speed=" + speed +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", engine=" + engine +
                ", verticalSpeed=" + verticalSpeed +
                ", maxTakeoffWeight=" + maxTakeoffWeight +
                ", takeoffWeight=" + takeoffWeight +
                ", enginesCount=" + enginesCount +
                '}';
    }

    public void setEnginesCount(int enginesCount) {
        this.enginesCount = enginesCount;
    }
}
