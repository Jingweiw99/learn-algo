package com.wjw.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private TrainStation trainStation = new TrainStation();

    public TrainStation createProxyObj() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TrainStation.class);
        // 设置回调
        enhancer.setCallback(this);
        TrainStation trainStation = (TrainStation) enhancer.create();
        return trainStation;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理点售票,收取手续费");
        Object obj = method.invoke(trainStation, objects);
        return obj;
    }
}
