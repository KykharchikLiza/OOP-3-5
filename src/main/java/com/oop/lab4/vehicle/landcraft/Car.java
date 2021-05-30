package com.oop.lab4.vehicle.landcraft;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oop.lab4.vehicle.Engine;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Bus.class, name = "bus"),
        @JsonSubTypes.Type(value = Sedan.class, name = "sedan"),
        @JsonSubTypes.Type(value = Truck.class, name = "truck"),
})
public abstract class Car extends LandCraft {

    protected String color;
    protected int doors;

    public Car(
            String serialNumber,
            int year,
            String brand,
            String color,
            int doors,
            Engine engine,
            int axisCount) {
        super(serialNumber, year, brand, engine, axisCount);
        this.color = color;
        this.doors = doors;
    }

    public Car() {
    }

    public int getDoors() {
        return doors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
}
