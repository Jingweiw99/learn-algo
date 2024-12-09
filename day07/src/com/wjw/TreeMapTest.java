package com.wjw;

import java.util.TreeMap;

/*
TreeMap的api测试
使用二叉搜索树实现的map结构
默认按照键升序排序。
 */
public class TreeMapTest {
    public static void main(String[] args) {

        test2();
    }

    static void tes1() {
        TreeMap<String, Integer> map = new TreeMap<>();
        // 增加
        map.put("a", 1);
        map.put("b", 2);

        map.putIfAbsent("a", 2); // 存在了没添加上
        System.out.println(map.get("a"));
        // 查看总体键值 情况
        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        System.out.println(map.values());
        // 获取单个值
        System.out.println(map.get("a"));
        System.out.println(map.getOrDefault("c", 0)); // 获取c，获取不到默认给0

//        System.out.println(map.remove("b", 3)); // 这里需要b -> 3才能删除成功
//        System.out.println(map.remove("b", 2)); // 这个返回boolean值
//        System.out.println(map.remove("a")); // 这个返回删除的元素
        // 修改
        map.put("a", 2);
        System.out.println(map.get("a"));
        map.replace("a", 3);
        System.out.println(map.get("a"));
        // firstKey lastKey
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
    }
    static void test2(){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(2,2);
        map.put(3,3);
        map.put(1,1);
        map.put(4,4);
        map.put(5,5);

        System.out.println(map.keySet()); // 排好序的key 1 2 3 4 5
        System.out.println(map.floorKey(4)); // 小于等于key的最大键
        System.out.println(map.ceilingEntry(5)); // 大于等于 5 的最小键

    }
}
