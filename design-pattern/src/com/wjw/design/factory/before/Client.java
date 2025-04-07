package com.wjw.design.factory.before;

public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
//        Coffee coffee = store.orderCoffee("American");
        Coffee coffee = store.orderCoffee("Latte");
        System.out.println(coffee);
    }
}
