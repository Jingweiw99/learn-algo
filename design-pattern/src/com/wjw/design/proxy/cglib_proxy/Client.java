package com.wjw.design.proxy.cglib_proxy;

public class Client {
    public static void main(String[] args) {
        // 这里会缺少 asm的依赖，使用maven没有问题
        TrainStation trainStation = new ProxyFactory().createProxyObject();
        trainStation.sell();
    }
}
