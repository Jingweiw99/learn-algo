package com.wjw.design.pattern.singleton.demo09;


import java.lang.reflect.Constructor;

/*
可以使用文件输入输出流来破坏单例模式
也可以使用反射来破坏单例模式这里采用反射模式来演示
JDK java.lang.Runtime就是使用的单例模式
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Class<Singleton> clazz = Singleton.class;
        Constructor<Singleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true); // 设置可以访问
        Singleton singleton = constructor.newInstance();
        Singleton singleton2 = constructor.newInstance();
        System.out.println(singleton2 == singleton); // false 说明已经劈坏了反射
    }
}
