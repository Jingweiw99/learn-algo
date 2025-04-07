package com.wjw.design.decorate;

public class Bacon extends Garnish {

    public Bacon(FastFood fastFood) {
        super(fastFood, 2.0, "培根");
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
