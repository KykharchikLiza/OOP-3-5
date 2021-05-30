package com.oop.lab4.vehicle.watercraft;

import com.oop.lab4.vehicle.Engine;

public class CruiseLiner extends Ship {

    private int maxPassengers;
    private int passengers;
    private int decks;

    public CruiseLiner(
            String serialNumber,
            int year,
            String brand,
            int crew,
            int maxPassengers,
            Engine engine,
            int displacement,
            int decks) {
        super(serialNumber, year, brand, crew, engine, displacement);
        this.maxPassengers = maxPassengers;
        this.decks = decks;
    }

    public CruiseLiner() {
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getDecks() {
        return decks;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public void setDecks(int decks) {
        this.decks = decks;
    }

    @Override
    public String toString() {
        return "CruiseLiner{" +
                "speed=" + speed +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", engine=" + engine +
                ", maxPassengers=" + maxPassengers +
                ", passengers=" + passengers +
                ", decks=" + decks +
                '}';
    }
}
