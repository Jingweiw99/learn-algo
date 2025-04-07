package com.wjw.design.factory.simple_factory;


/**
 * 简单工厂模式
 * 不在gof 23中设计模式中，但是开发中会经常这样写
 * 工厂只对对象进行创建
 */
public class SimpleFactory {

    public static Coffee createCoffee(String type) {
        Coffee coffee = null;
        if ("American".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("Latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("对不起，您点的咖啡不存在");
        }
        return coffee;
    }
}
