package com.oop.lab4.vehicle.adapter;

import com.oop.lab4.vehicle.Movable;

public class MileMovableAdapter implements MovableAdapter{

    private final Movable movable;

    public MileMovableAdapter(Movable movable) {
        this.movable = movable;
    }

    @Override
    public double getSpeed() {
        return convertKmPHtoMPH(movable.getSpeed());
    }

    private double convertKmPHtoMPH(double kmph)  {
        return kmph / 1.60934;
    }
}
