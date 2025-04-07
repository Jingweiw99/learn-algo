package com.wjw.LinkedHashMap;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MyLinkedHashMap<K, V> {
    private HashMap<K, Node<K, V>> map = new HashMap<>();
    private Node<K, V> head;
    private Node<K, V> tail;

    class Node<K, V> {
        K key;
        V value;
        Node prev;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyLinkedHashMap() {
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        if (map.get(key) == null)
            return null;
        return map.get(key).value;
    }

    // 添加或者是修改
    public void put(K key, V val) {
        // 判断get key 是否可以获取值  是：修改值  否：添加上值
        if (map.containsKey(key)) {
            map.get(key).value = val;
        } else {
            Node node = new Node(key, val);
            map.put(key, node);
            // 当前节点.next -> tail 当钱节点.prev -> 前一个节点  前一个几点.next -> 当前节点 tail.prev -> 当前节点
            putEnd(node);
        }
    }

    public void remove(K key) {
        // hash表数据中删除数据 并删除在链表中的数据
        Node<K, V> node = map.get(key);
        // node前一个节点next -> node的下一个节点  node的下一个节点指向node的前一个节点
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        map.remove(key);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public void addLastNode(Node<K, V> x) {
        // 添加到尾节点 双链表中添加到尾节点
        K key = x.key;
        map.put(key, x);
        putEnd(x);
    }

    // 给一个节点移出出
    public void removeNode(Node<K, V> x) {
        // 首先获取key，通过key在hash表中删除，然后再双向链表中删除
        K key = x.key;
        Node<K, V> node = map.get(key);
        map.remove(key);
        // 双向链表中删除
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public Set<K> keys() {
        return map.keySet();
    }

    // 将一个Node放到队尾的前面
    private void putEnd(Node<K, V> x) {
        Node prev = tail.prev;
        prev.next = x;
        x.prev = prev;
        x.next = tail;
        tail.prev = x;
    }


    public static void main(String[] args) {
        MyLinkedHashMap<String, Integer> map = new MyLinkedHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);

        System.out.println(map.keys()); // [a, b, c, d, e]
        map.remove("c");
        System.out.println(map.keys()); // [a, b, d, e]
    }
}
