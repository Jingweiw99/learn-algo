package com.wjw.design.decorate;

public class FriedRice extends FastFood {

    public FriedRice() {
        super(12.0, "炒饭");
    }

    @Override
    public double cost() {
        return super.getPrice();
    }
}
