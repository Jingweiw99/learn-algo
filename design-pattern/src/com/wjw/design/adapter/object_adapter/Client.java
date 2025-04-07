package com.wjw.design.adapter.object_adapter;

/*
对象适配器模式： 类适配器模式违反了合成复用原则
修改为适配器对象去聚合TFCard
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        System.out.println(computer.readSD(new SDCardImpl())); // 会首先打印你读取sd card的数据，然后打印出sd car的数据

        System.out.println("===============");
        SDAdapterTF sdAdapterTF = new SDAdapterTF(new TFCardImpl());
        String msg = computer.readSD(sdAdapterTF);
        System.out.println(msg);
    }
}
