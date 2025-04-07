package com.wjw.design.pattern.singleton.demo04;

/**
 * 懒汉式实现单例模式
 * 使用synchronize修饰方法 synchronize只能修饰方法或者代码
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static synchronized Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
