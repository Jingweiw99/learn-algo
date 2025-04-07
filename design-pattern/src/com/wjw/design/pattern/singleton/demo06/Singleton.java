package com.wjw.design.pattern.singleton.demo06;

/**
 * 使用静态内部类来创建单例对象
 * 第一次加载Singleton的时候，JVM不会加载SingletonHolder，只有在调用的时候才会加载SingletonHolder
 */
public class Singleton {


    private Singleton() {
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static synchronized Singleton getSingleton() {
        return SingletonHolder.INSTANCE;
    }
}
