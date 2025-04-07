package com.wjw.design.adapter.class_adapter;

/*
类适配器模式
客户端去调用 对应的方法
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        System.out.println(computer.readSD(new SDCardImpl())); // 会首先打印你读取sd card的数据，然后打印出sd car的数据

        System.out.println("===============");

        // 现在我想要让这个电脑去适配tf card 添加一个适配器类（由于这个类也是实现了SDCard接口，里面可以传入这个）
        System.out.println(computer.readSD(new SDAdapterTF())); // 先打印适配 然后打印 读取 tf card的数据， 然后打印 tf card的数据
    }
}
