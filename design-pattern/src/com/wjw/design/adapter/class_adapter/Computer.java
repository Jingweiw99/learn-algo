package com.wjw.design.adapter.class_adapter;

public class Computer {
    public String readSD(SDCard sdCard) {
        return sdCard.readSD();
    }

    public void writeSD(SDCard sdCard) {
        sdCard.writeSD();
    }
}
