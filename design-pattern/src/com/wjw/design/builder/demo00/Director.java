package com.wjw.design.builder.demo00;

/*
这个类可以抽给 Builder对象
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Bike construct() {
        return builder.buildBike();
    }
}
