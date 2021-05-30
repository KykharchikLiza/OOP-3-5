package com.oop.lab4.vehicle.watercraft;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oop.lab4.vehicle.Engine;
import com.oop.lab4.vehicle.Vehicle;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CargoShip.class, name = "cargoShip"),
        @JsonSubTypes.Type(value = CruiseLiner.class, name = "cruiseLiner"),
        @JsonSubTypes.Type(value = SailBoat.class, name = "sailBoat"),
        @JsonSubTypes.Type(value = Submarine.class, name = "submarine")
})
public abstract class WaterCraft extends Vehicle {

    private int crew;

    public WaterCraft(String serialNumber, int year, String brand, Engine engine, int crew) {
        super(serialNumber, year, brand, engine);
        this.crew = crew;
    }

    public WaterCraft() {
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }
}
