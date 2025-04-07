package com.wjw.design.builder.demo01;

/*
可以简单的抽取Director里面的方法到Builder中，但是不太符合单一原则。
简单的情况可以使用这个。
如果对象比较复杂，可以使用Director
 */
public class Client {
    public static void main(String[] args) {
        MobileBuilder builder = new MobileBuilder();
        Bike bike = builder.construct();
        System.out.println(bike);

        OfoBuilder ofoBuilder = new OfoBuilder();
        Bike bike1 = ofoBuilder.construct();
        System.out.println(bike1);
    }
}
