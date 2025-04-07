package com.wjw.design.builder.demo02;

/*
使用构造者模式简化开发
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .mainBoard("华硕")
                .screen("三星")
                .memory("海力士")
                .build();
        System.out.println(phone);
    }
}
