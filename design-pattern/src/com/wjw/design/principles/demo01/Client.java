package com.wjw.design.principles.demo01;

/**
 * 开闭原则：对扩展开放，对修改关闭
 * 这里有一个搜狗输入法，聚合了皮肤，将这个皮肤作为抽象类，
 * 其他皮肤多扩展的时候就不需要修改原来的代码了。
 */
public class Client {
    public static void main(String[] args) {
        SougouInput sougou = new SougouInput();
//        DefaultSkin defaultSkin = new DefaultSkin();
        AbstractSkin wjwSkin = new WjwSkin();
        sougou.setSkin(wjwSkin);
        sougou.display();
    }
}
