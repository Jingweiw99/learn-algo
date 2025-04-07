package com.wjw.design.factory.config_factory;

import com.wjw.design.factory.factory_method.Coffee;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class CoffeeFactory {
    private CoffeeFactory() {
    }

    // 1. 准备容器 map
    private static final HashMap<String, Object> map = new HashMap<>();

    // 2. 初始化容器
    static {
        Properties p = new Properties();
//        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("beans.properties");
        InputStream is = CoffeeFactory.class.getResourceAsStream("beans.properties");
        try {
            p.load(is);
            Set<Object> keys = p.keySet();
            for (Object key : keys) {
                String str =(String) p.get(key);
                Class clazz = Class.forName(str);
                Object coffee = (clazz.newInstance());
                map.put((String) key, coffee);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    // 3. 使用
    public static Object createCoffee(String name) {
        return  map.get(name);
    }
}
