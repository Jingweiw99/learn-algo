package com.wjw.design.proxy.JDKProxy;

import com.wjw.design.proxy.static_proxy.SellTickets;

public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        SellTickets sellTickets = factory.getProxyObject();
        sellTickets.sell();

        System.out.println(sellTickets.getClass());
        while(true){}
    }
}
