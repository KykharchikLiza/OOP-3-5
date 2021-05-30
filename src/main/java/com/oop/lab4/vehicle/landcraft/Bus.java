package com.oop.lab4.vehicle.landcraft;

import com.oop.lab4.vehicle.Engine;

public class Bus extends Car {

    private int maxPassengers;
    private int passengers;

    public Bus(
            String serialNumber,
            int year,
            String brand,
            String color,
            int doors,
            Engine engine,
            int axisCount,
            int maxPassengers) {
        super(serialNumber, year, brand, color, doors, engine, axisCount);
        this.maxPassengers = maxPassengers;
    }

    public Bus() {
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        if (passengers <= maxPassengers) {
            this.passengers = passengers;
        } else {
            //todo: many passengers
        }
    }

    @Override
    public String toString() {
        return "Bus{" +
                "speed=" + speed +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", engine=" + engine +
                ", maxPassengers=" + maxPassengers +
                ", passengers=" + passengers +
                ", color='" + color + '\'' +
                ", doors=" + doors +
                ", axisCount=" + axisCount +
                '}';
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }
}
