package com.wjw.design.adapter.object_adapter;

/**
 * 对象适配器模式
 * 适配器类 sd card适配 tf card
 * 需要实现SDCard，聚合TFCard的子实现类
 */
public class SDAdapterTF implements SDCard {
    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("sd适配了tf的 readSD方法");
        return tfCard.readTF();
    }

    @Override
    public void writeSD() {
        tfCard.writeTF();
    }
}
