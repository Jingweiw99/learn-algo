package com.wjw.design.decorate;

public class Egg extends Garnish {
    // 使用Egg包装FastFood
    public Egg(FastFood fastFood) {
        super(fastFood, 1.0, "鸡蛋");
    }

    @Override
    public double cost() {
        return super.getPrice() + super.getFastFood().cost();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + super.getFastFood().getDescription();
    }
}
