package com.wjw.design.principles.demo02.after;

public class Square implements Quadrangle {
    private double size;

    public void setWidth(double width) {
        size = width;
    }

    public void setLength(double length) {
        size = length;
    }

    @Override
    public double getWidth() {
        return size;
    }

    @Override
    public double getLength() {
        return size;
    }
}
