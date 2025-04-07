package com.wjw.design.prototype.demo02;

/*
使用场景：
对象创建比较复杂
对安全要求较高
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 给一原型，然后都创建多个学生的奖状
        // 如果我们内部是对应关系，奖状对应的事学生，这里的学生对象就是一个
        Citation citation = new Citation();
        Citation c1 = citation.clone();
        c1.setName("小王");
        c1.show();

        Citation c2 = citation.clone();
        c2.setName("小明");
        c2.show();
    }
}
