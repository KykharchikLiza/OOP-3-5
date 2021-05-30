package com.oop.lab4.vehicle.aircraft;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oop.lab4.vehicle.Engine;
import com.oop.lab4.vehicle.Vehicle;
import com.oop.lab4.vehicle.adapter.KnotMovableAdapter;
import com.oop.lab4.vehicle.adapter.MileMovableAdapter;
import com.oop.lab4.vehicle.adapter.MovableAdapter;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Blimp.class, name = "blimp"),
        @JsonSubTypes.Type(value = Helicopter.class, name = "helicopter"),
        @JsonSubTypes.Type(value = Plane.class, name = "plane"),
})
public abstract class AirCraft extends Vehicle {

    protected double verticalSpeed;
    protected double maxTakeoffWeight;
    protected double takeoffWeight;
    private int maxPassengers;
    private int passengers;

    public AirCraft(String serialNumber, int year, String brand, Engine engine, double maxTakeoffWeight, int maxPassengers) {
        super(serialNumber, year, brand, engine);
        this.maxTakeoffWeight = maxTakeoffWeight;
        this.maxPassengers = maxPassengers;
    }

    public AirCraft() {
    }

    @Override
    public String move() {
        MovableAdapter movableAdapter = new MileMovableAdapter(this);
        double miles = movableAdapter.getSpeed();
        if (engine != null) {
            engine.run();
        }
        return "Aircraft flies with speed: " + miles + " miles/hour";
    }

    @Override
    public String stop() {
        if (engine != null) {
            engine.stop();
        }
        return "Aircraft stops";
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        if (passengers <= maxPassengers) {
            this.passengers = passengers;
        } else {
            //todo: many passengers
        }
    }

    public double getVerticalSpeed() {
        return verticalSpeed;
    }

    public void setVerticalSpeed(double verticalSpeed) {
        this.verticalSpeed = verticalSpeed;
    }

    public double getTakeoffWeight() {
        return takeoffWeight;
    }

    public void setTakeoffWeight(double takeoffWeight) {
        if (takeoffWeight <= maxTakeoffWeight) {
            this.takeoffWeight = takeoffWeight;
        } else {
            //todo: weight
        }
    }

    public double getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public void setMaxTakeoffWeight(double maxTakeoffWeight) {
        this.maxTakeoffWeight = maxTakeoffWeight;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }
}
