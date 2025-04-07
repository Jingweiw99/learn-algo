package com.wjw.design.builder.demo00;

/**
 * 构造者(Builder)模式包含如下角色：
 * 1. 抽象建造者类(Builder)：对顶要实现复杂对象的那些部分的创建，并不涉及具体的对象部件的创建
 * 2. 具体构造者类，继承抽象构造者类，实现其方法，完成复杂的构建过程
 * 3. 产品类(Product)：要创建的复杂对象
 * 4. 指挥者类（Director）：调用建造者来创建复杂对象的各个部分。
 */
public class Client {
    public static void main(String[] args) {
        MobileBuilder builder = new MobileBuilder();
        Director director = new Director(builder);
        Bike bike = director.construct();
        System.out.println(bike);

        Director director1 = new Director(new OfoBuilder());
        Bike bike1 = director1.construct();
        System.out.println(bike1);
    }
}
