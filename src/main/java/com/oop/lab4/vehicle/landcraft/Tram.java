package com.oop.lab4.vehicle.landcraft;

import com.oop.lab4.vehicle.Engine;

public class Tram extends Railway {

    private int maxPassengers;
    private int passengers;

    public Tram(
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

    public Tram() {
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
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
        return "Tram{" +
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
