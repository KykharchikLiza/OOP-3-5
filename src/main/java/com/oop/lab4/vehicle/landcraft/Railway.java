package com.oop.lab4.vehicle.landcraft;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oop.lab4.vehicle.Engine;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Metro.class, name = "metro"),
        @JsonSubTypes.Type(value = Train.class, name = "train"),
        @JsonSubTypes.Type(value = Tram.class, name = "tram")
})
public abstract class Railway extends LandCraft {

    private double trackWidth;
    private int wagons;

    public Railway(String serialNumber, int year, String brand, Engine engine, int axisCount, double trackWidth) {
        super(serialNumber, year, brand, engine, axisCount);
        this.trackWidth = trackWidth;
    }

    public Railway() {
    }

    public int getWagons() {
        return wagons;
    }

    public void setWagons(int wagons) {
        this.wagons = wagons;
    }

    public double getTrackWidth() {
        return trackWidth;
    }

    public void setTrackWidth(double trackWidth) {
        this.trackWidth = trackWidth;
    }
}
