package com.wjw.design.decorate;

public abstract class FastFood {
    private double price;
    private String description;

    public FastFood(double price, String description) {
        this.price = price;
        this.description = description;
    }
    // 快餐的价格，由后面计算
    public abstract double cost();

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
