package com.wjw.design.pattern.singleton.demo05;

/**
 * 双重检查锁模式 (有风险)
 * 懒汉式实现单例模式
 * 使用synchronize修饰代码
 * 这里读多，创建的时候少， 是第一创建的时候我们上锁，然后再次判断是否为空，实例化对象
 */
public class Singleton {
    private static Singleton singleton;

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
