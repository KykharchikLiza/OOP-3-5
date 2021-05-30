package com.oop.lab4.vehicle.landcraft;

import com.oop.lab4.vehicle.Engine;

public class Metro extends Railway {

    private int maxPassengers;
    private int passengers;

    public Metro(
            String serialNumber,
            int year,
            String brand,
            Engine engine,
            int axisCount,
            double trackWidth,
            int maxPassengers) {
        super(serialNumber, year, brand, engine, axisCount, trackWidth);
        this.maxPassengers = maxPassengers;
    }

    public Metro() {
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

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public String toString() {
        return "Metro{" +
                "speed=" + speed +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", engine=" + engine +
                ", axisCount=" + axisCount +
                ", maxPassengers=" + maxPassengers +
                ", passengers=" + passengers +
                '}';
    }
}
