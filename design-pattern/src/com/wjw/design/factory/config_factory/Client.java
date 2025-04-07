package com.wjw.design.factory.config_factory;


public class Client {

    public static void main(String[] args) {
        Coffee coffee = (Coffee) CoffeeFactory.createCoffee("AmericanCoffee");
        System.out.println(coffee);

        Coffee coffee2 = (Coffee) CoffeeFactory.createCoffee("LatteCoffee");
        System.out.println(coffee2);
    }
}
