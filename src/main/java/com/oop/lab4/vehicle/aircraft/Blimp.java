package com.oop.lab4.vehicle.aircraft;

import com.oop.lab4.vehicle.Engine;

public class Blimp extends AirCraft {

    private int volume;

    public Blimp(String serialNumber, int year, String brand, Engine engine, double maxTakeoffWeight, int maxPassengers, int volume) {
        super(serialNumber, year, brand, engine, maxTakeoffWeight, maxPassengers);
        this.volume = volume;
    }

    public Blimp() {
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Blimp{" +
                "speed=" + speed +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", engine=" + engine +
                ", verticalSpeed=" + verticalSpeed +
                ", maxTakeoffWeight=" + maxTakeoffWeight +
                ", takeoffWeight=" + takeoffWeight +
                ", volume=" + volume +
                '}';
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
