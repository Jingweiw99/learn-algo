package com.wjw.design.factory.simple_factory;

public abstract class Coffee {
    public abstract String getName();

    // 加糖
    public void addSuger() {
        System.out.println("咖啡加糖");
    }

    // 加奶
    public void addMilk() {
        System.out.println("咖啡加奶");
    }
}
