package com.oop.lab4.vehicle.watercraft;

import com.oop.lab4.vehicle.Engine;

public class CargoShip extends Ship {

    private int deadweight;
    private int cargoWeight;

    public CargoShip(String serialNumber, int year, String brand, Engine engine, int crew, int displacement, int deadweight) {
        super(serialNumber, year, brand, crew, engine, displacement);
        this.deadweight = deadweight;
    }

    public CargoShip() {
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        if (cargoWeight <= deadweight) {
            this.cargoWeight = cargoWeight;
        } else {
            //todo::
        }
    }

    public int getDeadweight() {
        return deadweight;
    }

    public void setDeadweight(int deadweight) {
        this.deadweight = deadweight;
    }

    @Override
    public String toString() {
        return "CargoShip{" +
                "speed=" + speed +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", engine=" + engine +
                ", deadweight=" + deadweight +
                ", cargoWeight=" + cargoWeight +
                '}';
    }
}
