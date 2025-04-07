package com.wjw.design.proxy.JDKProxy;

import com.wjw.design.proxy.static_proxy.SellTickets;

public class TrainStation implements SellTickets {

    @Override
    public void sell() {
        System.out.println("火车站售票~");
    }
}
