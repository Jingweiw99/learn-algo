package com.wjw.design.pattern.singleton.demo10;

import javax.xml.stream.events.Characters;
import java.io.IOException;
import java.io.InputStream;

public class RuntimeDemo {
    public static void main(String[] args) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("ipconfig");
        InputStream is = process.getInputStream();
        // 一次性全部读取出来
        byte[] bytes = new byte[1024 * 1024 * 100];
        int len = is.read(bytes);
        String string = new String(bytes, 0, len, "GBK");
        System.out.println(string);
    }
}
