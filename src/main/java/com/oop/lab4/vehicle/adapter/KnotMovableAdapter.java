package com.oop.lab4.vehicle.adapter;

import com.oop.lab4.vehicle.Movable;

public class KnotMovableAdapter implements MovableAdapter{

    private final Movable movable;

    public KnotMovableAdapter(Movable movable) {
        this.movable = movable;
    }

    @Override
    public double getSpeed() {
        return convertKmPHtoKnots(movable.getSpeed());
    }

    private double convertKmPHtoKnots(double kmph)  {
        return kmph / 1.85;
    }
}
