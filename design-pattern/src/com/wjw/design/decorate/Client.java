package com.wjw.design.decorate;

public class Client {
    public static void main(String[] args) {
        FastFood food = new FriedNoddle();
        System.out.println(food.cost());
        // 炒面上加鸡蛋
        food = new Egg(food);
        System.out.println(food.getDescription() + " 的价格为" + food.cost());
        // 鸡蛋炒面上加上鸡蛋
        food = new Egg(food);
        System.out.println(food.getDescription() + " 的价格为" + food.cost());
        // 鸡蛋鸡蛋炒面上加上培根
        food = new Bacon(food);
        System.out.println(food.getDescription() + " 的价格为" + food.cost());
    }
}
