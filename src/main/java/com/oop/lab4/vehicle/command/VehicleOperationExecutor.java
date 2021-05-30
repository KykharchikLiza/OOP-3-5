package com.oop.lab4.vehicle.command;

import java.util.ArrayList;
import java.util.List;

public class VehicleOperationExecutor {

    private final List<VehicleOperation> operations = new ArrayList<>();

    public void add(VehicleOperation operation){
        operations.add(operation);
    }

    public String execute(){
        StringBuilder stringBuilder = new StringBuilder();

        operations.forEach(operation -> stringBuilder.append(operation.execute()).append("\n"));
        operations.clear();
        return stringBuilder.toString();
    }
}
