package com.wjw;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
使用数组加强hash表
实现一个map 具有
V get(K key)
void put(K key, V value)
void remove(K key);
boolean containsKey();
List<K> keys();
K randomKey();
要求增删改查的时间复杂度还是 O（1）随机访问一个key的时间复杂度也是O(1)
如果key存在空值的情况我们应该怎么做？
通过一个数组维护所有的key，
 */
public class ArrayHashMap<K, V> {
    private static class Node<K, V> {
        K key;
        V val;

        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private ArrayList<Node<K, V>> list = new ArrayList<>();
    private HashMap<K, Integer> map = new HashMap<>();
    private Random ran = new Random();

    public V get(K key) {
        return list.get(map.get(key)).val;
    }

    public void put(K key, V value) {
        // 修改  添加
        // 判断是否包含 是： 修改 否：添加
        // 修改需要修改map中的value
        // 添加需要添加map中的key 需要添加数组中的key
        if (!map.containsKey(key)) {
            list.add(new Node<>(key, value));
            map.put(key, list.size() - 1);
        }
        // 这里还需要获取 通过key获取到索引的位置。。。
        map.put(key, map.get(key));
    }

    public void remove(K key) {
        // 然后更新最后一个位置的key -> index
        int index = map.get(key); // 原来的index
        map.remove(key);
        int lastIndex = list.size() - 1;
        Node<K, V> node = list.get(lastIndex);
        list.set(index, node);
        list.remove(list.size() - 1);
        // map更新 node.key -> index
        map.put(node.key, index);
//        list.remove(key); // 这里先找到key对应的索引index, 找到最后一个索引 list.size() -1 交换一下
        // 交换了
        // 这里是O(n)的我们需要修改为O(1)的算法 我们可以修改为删除动态数组的最后一个值
        // 需要交换当前位置 和最后一个位置。  。。 需要得到当前的索引  问题转化为由一个key，常数时间内获取其在动态数组中的索引

    }

    public K randomKey() {
        // 这里还需要存储key 只存储value，不能完成，需要额外封装一个Node
        return list.get(ran.nextInt(map.size())).key;
    }

    public Set<K> keys() {
        return map.keySet();
    }

    public static void main(String[] args) {
        ArrayHashMap<Integer, Integer> map = new ArrayHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        System.out.println(map.get(1)); // 1
        System.out.println(map.randomKey()); // random
        map.remove(4);
        System.out.println("=============================");
        for (int i = 0; i < 100; i++) {
            if (map.randomKey() == 4)
                System.out.println("出错啦！");
            System.out.println(map.randomKey()); // random
        }
    }
}
