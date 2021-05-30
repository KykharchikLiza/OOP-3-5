package com.oop.lab4.vehicle.decorator;

import com.oop.lab4.vehicle.Movable;

public class SlowMoveDecorator extends MoveDecorator{

    public SlowMoveDecorator(Movable movable) {
        super(movable);
    }

    @Override
    public String move() {
        return "Vehicle moves slow \n" + super.move();
    }
}
