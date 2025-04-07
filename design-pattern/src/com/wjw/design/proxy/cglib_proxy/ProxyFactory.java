package com.wjw.design.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private TrainStation trainStation = new TrainStation();

    public TrainStation createProxyObject() {
        Enhancer enhancer = new Enhancer();
        // 设置字节码对象
        enhancer.setSuperclass(TrainStation.class);
        // 设置回调
        enhancer.setCallback(this);
        TrainStation trainStation = (TrainStation) enhancer.create();
        return trainStation;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理售票点收取手续费。。。");
        return method.invoke(trainStation, objects);
    }
}
