package com.wjw.design.proxy.JDKProxy;

import com.wjw.design.proxy.static_proxy.SellTickets;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private TrainStation trainStation = new TrainStation();

    public SellTickets getProxyObject() {
        SellTickets proxyInstance = (SellTickets) Proxy.newProxyInstance(
                trainStation.getClass().getClassLoader(),
                trainStation.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理口收手续费");
                        Object res = method.invoke(trainStation, args);
                        return res;
                    }
                });
        return proxyInstance;
    }
}
