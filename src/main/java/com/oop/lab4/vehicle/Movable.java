package com.oop.lab4.vehicle;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oop.lab4.vehicle.aircraft.Blimp;
import com.oop.lab4.vehicle.aircraft.Helicopter;
import com.oop.lab4.vehicle.aircraft.Plane;
import com.oop.lab4.vehicle.landcraft.*;
import com.oop.lab4.vehicle.watercraft.CargoShip;
import com.oop.lab4.vehicle.watercraft.CruiseLiner;
import com.oop.lab4.vehicle.watercraft.SailBoat;
import com.oop.lab4.vehicle.watercraft.Submarine;

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
public interface Movable {
    String move();

    String stop();

    double getSpeed();
}
