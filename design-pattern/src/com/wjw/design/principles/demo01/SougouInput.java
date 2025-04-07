package com.wjw.design.principles.demo01;

import lombok.Data;

/**
 * 搜狗拼音输入法类 可以设置皮肤
 */
@Data
public class SougouInput {
    private AbstractSkin skin;

    public void display() {
        skin.display();
    }
}
