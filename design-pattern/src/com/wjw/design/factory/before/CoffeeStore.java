package com.wjw.design.factory.before;

public class CoffeeStore {
    /**
     * @param type "American" "Latte"
     * @return
     */
    public Coffee orderCoffee(String type) {
        Coffee coffee = null;
        if ("American".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("Latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("对不起，您点的咖啡不存在");
        }
        coffee.addSuger();
        coffee.addMilk();
        return coffee;
    }
}
