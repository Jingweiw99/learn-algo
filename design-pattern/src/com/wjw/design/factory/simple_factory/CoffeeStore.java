package com.wjw.design.factory.simple_factory;

public class CoffeeStore {
    /**
     * @param type "American" "Latte"
     * @return
     */
    public Coffee orderCoffee(String type) {
        Coffee coffee = SimpleFactory.createCoffee(type);
        coffee.addSuger();
        coffee.addMilk();
        return coffee;
    }
}
