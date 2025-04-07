package com.wjw.design.factory.config_factory;

public class AmericanCoffee extends Coffee {
    private String name = "American";

    public AmericanCoffee() {
    }

    @Override
    public String getName() {
        return name;
    }
}
