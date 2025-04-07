package com.wjw.cglib_proxy;

public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        TrainStation trainStation = proxyFactory.createProxyObj();
        System.out.println(trainStation.sell("上海火车站"));
    }
}
