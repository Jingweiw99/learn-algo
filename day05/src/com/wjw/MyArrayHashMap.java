package com.wjw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
这个函数要在o1的时间去移除k，调用randomKey随机返回一个key，时间o1
如果通过keySet 获取key的set 然后random获取那么事件复杂度为on


 */
public class MyArrayHashMap<K, V> {
    // 存储 key 和 key 在 arr 中的索引
    private final HashMap<K, Integer> map = new HashMap<>();
    // 真正存储 key-value 的数组
    private final ArrayList<Node<K, V>> arr = new ArrayList<>();
    private final Random r = new Random();

    private static class Node<K, V> {
        K key;
        V val;

        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    MyArrayHashMap() {
    }

    public V get(K key) {
        // 获取的时候需要再arr中获取
        if (!map.containsKey(key)) {
            return null;
        }
        // 获取key再map中的索引
        int index = map.get(key);
        return arr.get(index).val;
    }

    /*
    如果map中不包含key 说明实际数据中也不包含key，需要添加进arr  同时更新对应key的 map
    包含了key的情况 获取到当前的key索引 array值进行修改
     */
    public void put(K key, V value) {
        if (!map.containsKey(key)) {
            Node<K, V> node = new Node<>(key, value);
            arr.add(node); // addLast
            map.put(key, arr.size() - 1);
        } else {
            int i = map.get(key); // 当前的key
            arr.get(i).val = value;
        }
    }

    /*
    对于key对应的值进行移除， ，需要移除arr对应的值(直接移除时间复杂度O(n)) 需要移除map中的索引
    我们移除arr中的值的时候需要交换之后移除
     */
    public void remove(K key) {
        if (!map.containsKey(key)) {
            return;
        }
        int index = map.get(key);
        int endIndex = arr.size() - 1;
        Node<K, V> indexNode = arr.get(index);
        Node<K, V> endIndexNode = arr.get(endIndex);
        arr.set(arr.size() - 1, indexNode);
        arr.set(index, endIndexNode);
        arr.remove(arr.size() - 1);

        map.remove(key);
    }


    public K randomKey() {
        int n = arr.size();
        int randomIndex = r.nextInt(n);
        return arr.get(randomIndex).key;
    }

    public static void main(String[] args) {
        // get put添加和更新 remove randomKey测试
        MyArrayHashMap<String, Integer> myMap = new MyArrayHashMap<>();
        myMap.put("a", 1);
        myMap.put("b", 2);
        myMap.put("b", 3);
        int a = myMap.get("a");
        System.out.println(a); // 1
        int b = myMap.get("b");
        System.out.println(b); // 3
        int aCount = 0;
        for (int i = 0; i < 100000000; i++) {
            if (myMap.randomKey().equals("a")) {
                aCount++;
            }
        }
        System.out.println((double) aCount / 100000000); // 大约是1/2
        myMap.remove("b");
        int aCount2 = 0;
        for (int i = 0; i < 10000; i++) {
            if (myMap.randomKey().equals("a")) {
                aCount2++;
            }
        }
        System.out.println((double) aCount2 / 10000); // 1
    }

}
