package com.oop.lab4.vehicle.landcraft;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oop.lab4.vehicle.Engine;
import com.oop.lab4.vehicle.Vehicle;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Bus.class, name = "bus"),
        @JsonSubTypes.Type(value = Sedan.class, name = "sedan"),
        @JsonSubTypes.Type(value = Truck.class, name = "truck"),
        @JsonSubTypes.Type(value = Metro.class, name = "metro"),
        @JsonSubTypes.Type(value = Train.class, name = "train"),
        @JsonSubTypes.Type(value = Tram.class, name = "tram")
})
public abstract class LandCraft extends Vehicle {

    protected int axisCount;

    public LandCraft(String serialNumber, int year, String brand, Engine engine, int axisCount) {
        super(serialNumber, year, brand, engine);
        this.axisCount = axisCount;
    }

    public LandCraft() {
    }

    @Override
    public String move() {
        if (engine != null) {
            engine.run();
        }
        return "Land craft moves with speed: " + speed + " km/h";
    }

    @Override
    public String stop() {
        if (engine != null) {
            engine.stop();
        }
        return "Land craft stops";
    }

    public int getAxisCount() {
        return axisCount;
    }

    public void setAxisCount(int axisCount) {
        this.axisCount = axisCount;
    }
}
