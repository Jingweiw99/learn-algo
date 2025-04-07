package com.wjw.design.decorate;

public class FriedNoddle extends FastFood {

    public FriedNoddle() {
        super(10.0, "炒面");
    }

    @Override
    public double cost() {
        return super.getPrice();
    }
}
