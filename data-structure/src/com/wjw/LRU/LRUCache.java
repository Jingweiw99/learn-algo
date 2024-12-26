package com.wjw.LRU;

import java.util.HashMap;

/*
这里是对的，优化版本可以查看day09/src/com/wjw/LRUCache.java
思考到map来O(1)级别获取和修改添加元素
需要手动维护最少最近。 也就是提升优先级。使用双向链表。。 外部通过key获取值，map维护实际的值。。
刚开始Node不需要key，但是在满容量的时候，同时需要删除map中的映射，需要通过Node删除map，也就是获取对应的key，那只能在Node里面添加维护key

 */
public class LRUCache {
    class Node {
        int val;
        int key;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    int size;
    HashMap<Integer, Node> keyToNode;
    Node head;
    Node tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        keyToNode = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-2, -2);
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        Node cur = keyToNode.get(key);
        // 从双链表中删除
        remove(cur);
        appendHead(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        if (keyToNode.containsKey(key)) {
            Node cur = keyToNode.get(key);
            // put里面原先是有的
            cur.val = value;
            remove(cur);
            appendHead(cur);
        } else {
            // 原先没有
            Node cur = new Node(key, value);
            keyToNode.put(key, cur);
            // 如果容量没有满直接添加到头部
            if (size < capacity) {
                appendHead(cur);
                size++;
            } else {
                // 如果容量满了，删除最后一个 tail前面一个
                keyToNode.remove(tail.prev.key);
                remove(tail.prev);
                // 删除keyToNode tail.prev的映射
                appendHead(cur);
            }
        }
    }

    private void appendHead(Node node) {
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
        head.next = node;
    }

    // 从双向链表中移除这个节点
    private void remove(Node node) {
        Node preNode = node.prev;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.prev = preNode;
        node.next = node.prev = null;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 11);
        cache.put(2, 22);
        System.out.println(cache.get(1)); // 11
        cache.put(3, 33); // 覆盖掉了不常用的2
        System.out.println(cache.get(2)); // -1

    }
}
