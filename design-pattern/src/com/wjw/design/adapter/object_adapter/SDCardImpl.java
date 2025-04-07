package com.wjw.design.adapter.object_adapter;

public class SDCardImpl implements SDCard {
    @Override
    public String readSD() {
        // 从读卡器从读取出数据
        System.out.println("你从SD卡 中读取了数据");
        String msg = "data sd";
        return msg;
    }

    @Override
    public void writeSD() {
        System.out.println("你从SD卡 中写入了数据");
    }
}
