package com.oop.lab4.vehicle;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.oop.lab4.vehicle.aircraft.Blimp;
import com.oop.lab4.vehicle.aircraft.Helicopter;
import com.oop.lab4.vehicle.aircraft.Plane;
import com.oop.lab4.vehicle.landcraft.*;
import com.oop.lab4.vehicle.watercraft.CargoShip;
import com.oop.lab4.vehicle.watercraft.CruiseLiner;
import com.oop.lab4.vehicle.watercraft.SailBoat;
import com.oop.lab4.vehicle.watercraft.Submarine;

import java.io.Serializable;
import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Bus.class, name = "bus"),
        @JsonSubTypes.Type(value = Sedan.class, name = "sedan"),
        @JsonSubTypes.Type(value = Truck.class, name = "truck"),
        @JsonSubTypes.Type(value = Metro.class, name = "metro"),
        @JsonSubTypes.Type(value = Train.class, name = "train"),
        @JsonSubTypes.Type(value = Tram.class, name = "tram"),
        @JsonSubTypes.Type(value = Blimp.class, name = "blimp"),
        @JsonSubTypes.Type(value = Helicopter.class, name = "helicopter"),
        @JsonSubTypes.Type(value = Plane.class, name = "plane"),
        @JsonSubTypes.Type(value = CargoShip.class, name = "cargoShip"),
        @JsonSubTypes.Type(value = CruiseLiner.class, name = "cruiseLiner"),
        @JsonSubTypes.Type(value = SailBoat.class, name = "sailBoat"),
        @JsonSubTypes.Type(value = Submarine.class, name = "submarine")
})
public abstract class Vehicle implements Movable, Serializable {
    protected static final long serialVersionUID = 1232324L;

    @JacksonXmlProperty(isAttribute = true)
    protected String serialNumber;

    protected double speed;
    protected int year;
    protected String brand;
    protected Engine engine;

    public Vehicle(String serialNumber, int year, String brand, Engine engine) {
        this.year = year;
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.engine = engine;
    }

    public Vehicle() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(serialNumber, vehicle.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
