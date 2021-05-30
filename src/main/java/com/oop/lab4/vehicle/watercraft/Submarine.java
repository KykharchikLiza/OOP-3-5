package com.oop.lab4.vehicle.watercraft;

import com.oop.lab4.vehicle.Engine;
import com.oop.lab4.vehicle.adapter.KnotMovableAdapter;
import com.oop.lab4.vehicle.adapter.MovableAdapter;
import com.oop.lab4.vehicle.adapter.MileMovableAdapter;

public class Submarine extends WaterCraft {

    private int maxDeep;
    private int deep;
    private int deepSpeed;

    public Submarine(String serialNumber, int year, String brand, Engine engine, int crew, int maxDeep) {
        super(serialNumber, year, brand, engine, crew);
        this.maxDeep = maxDeep;
    }

    public Submarine() {
    }

    @Override
    public String move() {
        MovableAdapter movableAdapter = new KnotMovableAdapter(this);
        double knots = movableAdapter.getSpeed();
        if (engine != null) {
            engine.run();
        }
        return "Submarine floats with speed" + knots;
    }

    @Override
    public String stop() {
        if (engine != null) {
            engine.stop();
        }
        return "Submarine stops";
    }

    public int getMaxDeep() {
        return maxDeep;
    }

    public void setMaxDeep(int maxDeep) {
        this.maxDeep = maxDeep;
    }

    public int getDeep() {
        return deep;

    }

    public void setDeep(int deep) {
        if (deep <= maxDeep) {
            this.deep = deep;
        } else {
            //todo: deap
        }
    }

    public int getDeepSpeed() {
        return deepSpeed;
    }

    public void setDeepSpeed(int deepSpeed) {
        this.deepSpeed = deepSpeed;
    }

    @Override
    public String toString() {
        return "Submarine{" +
                "speed=" + speed +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", engine=" + engine +
                ", maxDeep=" + maxDeep +
                ", deep=" + deep +
                ", deepSpeed=" + deepSpeed +
                '}';
    }
}
