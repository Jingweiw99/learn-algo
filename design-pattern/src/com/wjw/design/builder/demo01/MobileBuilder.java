package com.wjw.design.builder.demo01;

public class MobileBuilder extends Builder {

    @Override
    public void buildFrame() {
        System.out.println("全铝合金frame");
    }

    @Override
    public void buildSeat() {
        System.out.println("纯真皮座椅");
    }

    @Override
    public Bike buildBike() {
        buildFrame();
        buildSeat();
        return super.bike;
    }
}
