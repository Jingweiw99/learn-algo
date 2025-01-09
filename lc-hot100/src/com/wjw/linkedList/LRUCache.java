package com.wjw.linkedList;

import java.util.HashMap;

class LRUCache {
    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        Node(int key, int val) {
            this(key, val, null, null);
        }

        Node(int key, int val, Node pre, Node next) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private int size;
    private Node head;
    private Node tail;


    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        tail = new Node(Integer.MIN_VALUE, Integer.MAX_VALUE);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        removeEle(cur);
        appendHead(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        // put 容量没有满  容量满了
//        if (size < capacity) {
//            Node cur = new Node(key, value);
//            map.put(key, cur);
//            appendHead(cur);
//            size++;
//        } else {
//            // 这里自然会想到在Node中添加一个key，不然由tail.pre无法找到key 无法删除map中对应的键值对
//            map.remove(tail.pre.key);
//            removeEle(tail.pre);
//            size--;
//
//            Node cur = new Node(key, value);
//            map.put(key, cur);
//            appendHead(cur);
//            size++;
//        }
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            removeEle(cur);
            appendHead(cur);
            map.put(key, cur);
            return;
        }
        // 下面是添加的情况
        if (size >= capacity) {
            map.remove(tail.pre.key);
            removeEle(tail.pre);
            size--;
        }
        Node cur = new Node(key, value);
        map.put(key, cur);
        appendHead(cur);
        size++;
    }

    private void appendHead(Node node) {
        Node headNxt = head.next;
        headNxt.pre = node;
        node.next = headNxt;
        node.pre = head;
        head.next = node;
    }

    private void removeEle(Node node) {
        Node pre = node.pre;
        Node nxt = node.next;
        nxt.pre = pre;
        pre.next = nxt;
        node.next = null;
        node.pre = null;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2)); // -1
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);//
        System.out.println(cache.get(1)); // 2
        System.out.println(cache.get(2)); // 6
    }
}
