package com.wjw.design.pattern.singleton.demo03;

/**
 * 懒汉式实现单例模式，在多线程环境下会出现创建多个对象的问题
 * 在多线程的环境下，多个线程都会创建上对象
 * 线程不安全的
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
