package com.wjw.design.pattern.singleton.demo01;

/*
饿汉式
静态变量
 */
public class Client {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(singleton1 == singleton2);
    }
}
