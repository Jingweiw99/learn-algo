package com.wjw.design.prototype.demo02;

public class Citation implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(name + "同学，这是你的奖状！");
    }
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }
}
