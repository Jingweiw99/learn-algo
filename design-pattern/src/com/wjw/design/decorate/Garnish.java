package com.wjw.design.decorate;

/*
装饰者类
继承了 抽象类 并且聚合了抽象类的子继承实例类，并且为抽象接口
 */
public abstract class Garnish extends FastFood {
    private FastFood fastFood;

    public Garnish(FastFood fastFood, double price, String description) {
        super(price, description);
        this.fastFood = fastFood;
    }

    public FastFood getFastFood() {
        return fastFood;
    }

    public abstract double cost();
}
