package com.wjw.design.factory.factory_method;

public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        // 需要添加上工厂
        store.setFactory(new AmericanCoffeeFactory());
        Coffee coffee = store.orderCoffee();
        System.out.println(coffee);
    }
}
