package com.wjw.design.factory.factory_method;


import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

public class CoffeeStore {
    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();
        coffee.addSuger();
        coffee.addMilk();
        return coffee;
    }
}
