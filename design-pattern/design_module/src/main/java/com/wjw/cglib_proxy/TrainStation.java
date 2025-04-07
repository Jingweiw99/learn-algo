package com.wjw.cglib_proxy;

public class TrainStation {
    public String sell(String name) {
        System.out.println("名称为" + name + "的火车站售票");
        return "test";
    }
}
