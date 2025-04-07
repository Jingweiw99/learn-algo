package com.wjw.design.principles.demo02.after;

/*
里氏代换原则：任何基类可以出现的地方，子类一定可以出现。繁殖
 */
public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setLength(20);
        resize(rectangle);
        printLengthAndWidth(rectangle);

        // 如果是正方形的情况 不能调用这个扩宽
        // 能在基类使用的，必须能在子类中使用。

    }

    // 扩宽方法
    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    // 打印长宽方法
    public static void printLengthAndWidth(Rectangle rectangle) {
        System.out.println(rectangle.getLength());
        System.out.println(rectangle.getWidth());
    }
}
