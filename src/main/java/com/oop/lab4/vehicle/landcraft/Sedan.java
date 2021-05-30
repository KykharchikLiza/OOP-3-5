package com.oop.lab4.vehicle.landcraft;

import com.oop.lab4.vehicle.Engine;

import static com.oop.lab4.vehicle.landcraft.Sedan.CarBodyType.SEDAN;

public class Sedan extends Car {

    private CarBodyType carBodyType = SEDAN;

    public Sedan(
            String serialNumber,
            int year,
            String brand,
            String color,
            int doors,
            Engine engine,
            CarBodyType carBodyType) {
        super(serialNumber, year, brand, color, doors, engine, 2);
        this.carBodyType = carBodyType;
    }

    public Sedan() {
    }

    public enum CarBodyType {
        SEDAN,
        CABRIOLET,
        HATCHBACK,
        WAGON
    }

    public CarBodyType getCarBodyType() {
        return carBodyType;
    }

    public void setCarBodyType(CarBodyType carBodyType) {
        this.carBodyType = carBodyType;
    }

    @Override
    public String toString() {
        return "Sedan{" +
                "speed=" + speed +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", engine=" + engine +
                ", color='" + color + '\'' +
                ", doors=" + doors +
                ", axisCount=" + axisCount +
                ", carBodyType=" + carBodyType +
                '}';
    }
}
