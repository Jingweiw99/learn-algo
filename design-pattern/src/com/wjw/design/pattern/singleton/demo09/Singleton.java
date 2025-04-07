package com.wjw.design.pattern.singleton.demo09;

/**
 * 双重检查锁模式 (标准模式)
 * 懒汉式实现单例模式
 * 使用synchronize修饰代码
 * 多线程环境下的正确性和可见性
 */
public class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {
    }

    public static synchronized Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
