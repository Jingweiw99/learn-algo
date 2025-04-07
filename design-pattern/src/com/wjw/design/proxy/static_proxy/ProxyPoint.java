package com.wjw.design.proxy.static_proxy;

import java.net.ProxySelector;

public class ProxyPoint implements SellTickets{
    private TrainStation trainStation = new TrainStation();

    public ProxyPoint() {}


    @Override
    public void sell() {
        System.out.println("代收点收手续费");
        trainStation.sell();
    }
}
