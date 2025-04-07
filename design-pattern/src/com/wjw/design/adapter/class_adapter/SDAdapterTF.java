package com.wjw.design.adapter.class_adapter;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 类适配器模式
 * 适配器类 sd card适配 tf card
 * 需要继承已经实现好了的TFCardImpl类，并且实现SDCard
 */
public class SDAdapterTF extends TFCardImpl implements SDCard {
    @Override
    public String readSD() {
        System.out.println("sd适配了tf的 readSD方法");
        return readTF();
    }

    @Override
    public void writeSD() {
        writeTF();
    }
}
