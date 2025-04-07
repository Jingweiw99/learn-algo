package com.wjw.design.adapter.class_adapter;

public class TFCardImpl implements TFCard {
    @Override
    public String readTF() {
        System.out.println("你读取出了tf卡的数据");
        String msg = "tf card data: xxxxxxx";
        return msg;
    }

    @Override
    public void writeTF() {
        System.out.println("写入数据到tf card中");
    }
}
