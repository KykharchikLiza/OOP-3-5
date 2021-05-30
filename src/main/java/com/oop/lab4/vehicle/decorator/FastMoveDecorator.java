package com.oop.lab4.vehicle.decorator;

import com.oop.lab4.vehicle.Movable;

public class FastMoveDecorator extends MoveDecorator{

    public FastMoveDecorator(Movable movable) {
        super(movable);
    }

    @Override
    public String move() {
        return "Vehicle moves fast \n" +  super.move();
    }
}
