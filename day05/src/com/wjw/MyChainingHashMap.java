package com.wjw;

import java.util.LinkedList;
import java.util.List;

public class MyChainingHashMap<K, V> {
    // 拉链法使用的单链表节点，存储 key-value 对
    private static class KVNode<K, V> {
        K key;
        V value;

        // 因为我们使用了内置的 LinkedList 类，所以不用 next 指针
        // 不用我们自己实现链表的逻辑
        KVNode(K key, V val) {
            this.key = key;
            this.value = val;
        }
    }

    private LinkedList<KVNode<K, V>>[] table;
    // hash表中存入kv的个数
    private int size;
    private static final int INIT_CAP = 4;

    public MyChainingHashMap() {
        this(INIT_CAP);

    }

    public MyChainingHashMap(int initCapacity) {
        size = 0;
        initCapacity = Math.max(initCapacity, 1);
        table = (LinkedList<KVNode<K, V>>[]) new LinkedList[initCapacity];
        for (int i = 0; i < initCapacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // 增   改
    // 不存在就添加，  存在就修改
    public void put(K key, V val) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        // 如果key之前存在，修改
        for (KVNode<K, V> node : list) {
            if (node.key.equals(key)) {
                node.value = val;
                return;
            }
        }
        // 如果key之前不存在
        list.add(new KVNode<>(key, val));
        size++;

        // 添加之后判断是否超过了负载因子
        if (size >= table.length * 0.75) {
            resize(table.length * 2);
        }
    }

    // 删除
    public void remove(K key) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        for (KVNode<K, V> node : list) {
            if (node.key.equals(key)) {
                list.remove(node);
                size--;
                // 减了之后也需要判断是否需要缩容 小于0.125
                if (size <= table.length / 8) {
                    resize(table.length / 4);
                }
                return;
            }
        }
    }

    // 查
    public V get(K key) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        LinkedList<KVNode<K, V>> list = table[hash(key)];
        for (KVNode<K, V> node : list) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    // 返回所有的key
    public List<K> keys() {
        List<K> keys = new LinkedList<>();
        for (LinkedList<KVNode<K, V>> list : table) {
            for (KVNode<K, V> node : list) {
                keys.add(node.key);
            }
        }
        return keys;
    }


    // 下面都是工具函数
    public int size() {
        return size;
    }


    // 哈希函数，将键映射到 table 的索引
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    private void resize(int newCap) {
        // 构造一个新的 HashMap
        // 避免 newCap 为 0，造成求模运算产生除以 0 的异常
        newCap = Math.max(newCap, 1);
        MyChainingHashMap<K, V> newMap = new MyChainingHashMap<>(newCap);
        // 穷举当前 HashMap 中的所有键值对
        for (LinkedList<KVNode<K, V>> list : table) {
            for (KVNode<K, V> node : list) {
                // 将键值对转移到新的 HashMap 中
                newMap.put(node.key, node.value);
            }
        }
        // 将当前 HashMap 的底层 table 换掉
        this.table = newMap.table;
    }

    public static void main(String[] args) {
        MyChainingHashMap<Integer, Integer> map = new MyChainingHashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println(map.get(1));
        map.put(1, 11);
        System.out.println(map.get(1));

        map.remove(1);
        System.out.println(map.size());

        System.out.println(map.keys());
    }
}
