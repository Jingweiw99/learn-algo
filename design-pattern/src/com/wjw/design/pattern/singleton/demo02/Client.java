package com.wjw.design.pattern.singleton.demo02;

/**
 * 使用饿汉式的静态代码快来初始化单实例对象
 */
public class Client {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(singleton1 == singleton2);
    }
}
