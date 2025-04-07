package com.wjw.design.principles.demo02.before;

public class Square extends Rectangle {
    public void setWidth(int width) {
        super.setWidth(width);
        super.setLength(width);
    }
    public void setLength(int length) {
        super.setWidth(length);
        super.setLength(length);
    }
}
