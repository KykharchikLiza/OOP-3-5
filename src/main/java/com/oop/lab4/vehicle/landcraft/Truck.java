package com.oop.lab4.vehicle.landcraft;

import com.oop.lab4.vehicle.Engine;

public class Truck extends Car {

    private int maxCargoWeight;
    private int cargoWeight;

    public Truck(
            String serialNumber,
            int year,
            String brand,
            String color,
            int doors,
            Engine engine,
            int axisCount,
            int maxCargoWeight) {
        super(serialNumber, year, brand, color, doors, engine, axisCount);
        this.maxCargoWeight = maxCargoWeight;
    }

    public Truck() {
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        if (cargoWeight <= maxCargoWeight) {
            this.cargoWeight = cargoWeight;
        } else {
            //todo: more maxWeight
        }
    }

    public int getMaxCargoWeight() {
        return maxCargoWeight;
    }

    public void setMaxCargoWeight(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "speed=" + speed +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", engine=" + engine +
                ", color='" + color + '\'' +
                ", doors=" + doors +
                ", axisCount=" + axisCount +
                ", maxCargoWeight=" + maxCargoWeight +
                ", cargoWeight=" + cargoWeight +
                '}';
    }
}
