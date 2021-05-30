package com.oop.lab4.vehicle.decorator;

import com.oop.lab4.vehicle.Movable;

public abstract class MoveDecorator implements Movable {
    protected Movable movable;

    public MoveDecorator(Movable movable) {
        this.movable = movable;
    }

    @Override
    public String move() {
        return movable.move();
    }

    @Override
    public String stop() {
        return movable.stop();
    }

    @Override
    public double getSpeed() {
        return movable.getSpeed();
    }
}
