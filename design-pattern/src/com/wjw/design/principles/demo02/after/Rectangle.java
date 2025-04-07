package com.wjw.design.principles.demo02.after;

import lombok.Data;

public class Rectangle implements Quadrangle {
    private double length;
    private double width;

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
