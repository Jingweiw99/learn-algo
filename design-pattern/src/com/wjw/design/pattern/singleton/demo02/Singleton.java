package com.wjw.design.pattern.singleton.demo02;

public class Singleton {
    private static Singleton singleton;

    static {
        singleton = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
