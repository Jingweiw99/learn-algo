package com.wjw.design.adapter.object_adapter;

public class Computer {
    public String readSD(SDCard sdCard) {
        return sdCard.readSD();
    }

    public void writeSD(SDCard sdCard) {
        sdCard.writeSD();
    }
}
