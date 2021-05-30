package com.oop.lab4.vehicle.watercraft;

public class SailBoat extends Ship {

    private int masts;

    public SailBoat(String serialNumber, int year, String brand, int crew, int displacement, int masts) {
        super(serialNumber, year, brand, crew, null, displacement);
        this.masts = masts;
    }

    public SailBoat() {
    }

    public void setMasts(int masts) {
        this.masts = masts;
    }

    public int getMasts() {
        return masts;
    }

    @Override
    public String toString() {
        return "SailBoat{" +
                "speed=" + speed +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", engine=" + engine +
                ", masts=" + masts +
                '}';
    }
}
