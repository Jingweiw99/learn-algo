package com.wjw.design.prototype.demo01;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype realizetype = new Realizetype();
        Realizetype realizetype1 = realizetype.clone();
        System.out.println(realizetype1 == realizetype); // false 克隆出来不是一个对象
    }
}
