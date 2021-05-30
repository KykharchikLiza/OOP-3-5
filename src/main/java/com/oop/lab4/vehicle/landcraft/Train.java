package com.oop.lab4.vehicle.landcraft;

import com.oop.lab4.vehicle.Engine;

public class Train extends Railway {

    public enum TrainType {
        STEAM,
        ELECTRIC,
        LOCOMOTIVE;
    }

    private TrainType trainType;

    public Train(String serialNumber, int year, String brand, Engine engine, int trackWidth, TrainType trainType) {
        super(serialNumber, year, brand, engine, trackWidth, trackWidth);
        this.trainType = trainType;
    }

    public Train() {
    }

    public TrainType getTrainType() {
        return trainType;
    }

    public void setTrainType(TrainType trainType) {
        this.trainType = trainType;
    }

    @Override
    public String toString() {
        return "Train{" +
                "speed=" + speed +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", engine=" + engine +
                ", axisCount=" + axisCount +
                ", trainType=" + trainType +
                '}';
    }
}
