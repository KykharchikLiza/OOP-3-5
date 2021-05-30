package com.oop.lab4.controller;


import com.oop.lab4.serialization.VehicleList;

public interface VehiclesController {

    void showVehicles(VehicleList vehicleList);

    void add();

    void edit();

    void delete();

}
