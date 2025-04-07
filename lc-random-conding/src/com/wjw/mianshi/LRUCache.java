package com.wjw.mianshi;

import java.util.HashMap;

/*
用于实现 最少最近使用缓存
给一个capacity最大容量，超过了这个容量淘汰最远没有使用的
int get(int key)  如果存在缓存中，返回关键字的值， 否则返回-1
void put(int key, int value) 修改或者插入
 */
public class LRUCache {
    private class Node {
        int key;
        int val;// 保存内部的值
        Node pre;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private int size; // 当前有效的值为多少
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-999, -999);
        tail = new Node(-888, -888);
        head.next = tail;
        tail.pre = head;
        this.size = 0;
        map = new HashMap<>();
    }

    // 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 提升优先级 (将当前的node在链表中删除 放入到head后面)
        Node cur = map.get(key);
        removeNode(cur);
        appendHead(cur);
        return cur.val;
    }

    private void appendHead(Node cur) {
        // 找到头结点 头结点下一个节点
        Node headNext = head.next;
        headNext.pre = cur;
        cur.next = headNext;
        cur.pre = head;
        head.next = cur;
    }

    // 从head - tail 中删除cur节点
    private void removeNode(Node cur) {
        Node preNode = cur.pre;
        Node nextNode = cur.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        cur.pre = null;
        cur.next = null;
    }


    // 修改或插入 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字
    public void put(int key, int value) {
        // 第一种是修改的情况，不会涉及到删除数据的问题
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            removeNode(cur);
            appendHead(cur);
        } else {
            // 如果不包含这个key，说明需要添加上
            // 判断size是否超过了容量
            Node cur = new Node(key, value);
            if (size >= capacity) {
                // 是：删除最久没有使用的节点(最后一个位置以上的节点,同时需要删除map中的键值对)，放入这个最新的节点
                Node removeNode = tail.pre;
                map.remove(removeNode.key);
                removeNode(removeNode);
                appendHead(cur);
                map.put(key, cur);
            } else {
                // 否：直接添加上， 然后size++
                appendHead(cur);
                map.put(key, cur);
                size++;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); //1
        cache.put(3, 3);
        System.out.println(cache.get(2)); // -1
        cache.put(4, 4);
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}
