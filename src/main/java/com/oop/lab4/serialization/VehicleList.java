package com.oop.lab4.serialization;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.oop.lab4.vehicle.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VehicleList implements Serializable {

    private static final long serialVersionUID = 123453524L;

    @JacksonXmlElementWrapper(localName = "vehicles")
    @JacksonXmlProperty(localName = "item")
    private final List<Vehicle> vehicles = new ArrayList<>();

    public VehicleList() {
    }

    public <T> List<T> castVehicles(Class<T> clazz) {
        List<T> list = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (clazz.isInstance(vehicle)) {
                @SuppressWarnings("unchecked")
                T typedObject = (T) vehicle;
                list.add(typedObject);
            }
        }
        return list;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

}
