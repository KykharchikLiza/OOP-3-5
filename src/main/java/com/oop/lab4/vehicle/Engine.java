package com.oop.lab4.vehicle;

import java.io.Serializable;

public class Engine implements Serializable {
    private static final long serialVersionUID = 89834L;
    private int engineCapacity;
    private int enginePower;

    public Engine(int engineCapacity, int enginePower) {
        this.engineCapacity = engineCapacity;
        this.enginePower = enginePower;
    }

    public Engine() {
    }

    public boolean run() {
        System.out.println("Engine run");
        return true;
    }

    public boolean stop() {
        System.out.println("Engine stop");
        return false;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineCapacity=" + engineCapacity +
                ", enginePower=" + enginePower +
                '}';
    }
}
