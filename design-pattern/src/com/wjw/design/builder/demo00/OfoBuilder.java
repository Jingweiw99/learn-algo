package com.wjw.design.builder.demo00;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        System.out.println("ofo frame");
    }

    @Override
    public void buildSeat() {
        System.out.println("ofo seat");
    }

    @Override
    public Bike buildBike() {
        buildFrame();
        buildSeat();
        return bike;
    }
}
