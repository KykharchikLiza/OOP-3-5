package com.oop.lab4.vehicle.watercraft;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oop.lab4.vehicle.Engine;
import com.oop.lab4.vehicle.adapter.KnotMovableAdapter;
import com.oop.lab4.vehicle.adapter.MovableAdapter;
import com.oop.lab4.vehicle.adapter.MileMovableAdapter;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CargoShip.class, name = "cargoShip"),
        @JsonSubTypes.Type(value = CruiseLiner.class, name = "cruiseLiner"),
        @JsonSubTypes.Type(value = SailBoat.class, name = "sail-boat"),
})
public abstract class Ship extends WaterCraft {

    private int displacement;

    public Ship(String serialNumber, int year, String brand, int crew, Engine engine, int displacement) {
        super(serialNumber, year, brand, engine, crew);
        this.displacement = displacement;
    }

    public Ship() {
    }

    @Override
    public String move() {
        MovableAdapter movableAdapter = new KnotMovableAdapter(this);
        double knots = movableAdapter.getSpeed();
        if (engine != null) {
            engine.run();
        }
        return "Vessel floats with speed: " + knots + " knots/hour";
    }

    @Override
    public String stop() {
        if (engine != null) {
            engine.stop();
        }
        return "Vessel stops";
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }
}
