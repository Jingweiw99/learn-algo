package com.wjw.design.builder.demo00;

public abstract class Builder {
    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract Bike buildBike();
}
