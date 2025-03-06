package com.wjw;


import java.util.HashMap;

public class LRUCache_ {
    class Node {
        public int key, val;
        public Node next, pre;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache_(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-2, -2);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    // 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1
    public int get(int key) {
        // 先去判断是否在缓存中
        if (!map.containsKey(key)) {
            // 不在 return -1
            return -1;
        }
        // 在 获取值 提升优先级 然后返回当前的值
        Node curNode = map.get(key);
        // 移除当前节点
        removeNode(curNode);
        // 放到head后面
        appendHead(curNode);
        return curNode.val;
    }

    private void appendHead(Node node) {
        // node节点的next->原head的下一个节点headNext  headNext.pre -> node  head.next -> node  node.pre -> head
        Node headNext = head.next;
        node.next = headNext;
        headNext.pre = node;
        node.pre = head;
        head.next = node;
    }

    private void removeNode(Node node) {
        // node 的pre -> null next -> null 前一个节点的next->nxtNode 后一个节点的pre->preNode
        Node preNode = node.pre;
        Node nxtNode = node.next;
        node.pre = null;
        node.next = null;
        preNode.next = nxtNode;
        nxtNode.pre = preNode;
    }

    // 修改或插入  如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字
    public void put(int key, int value) {
        // 判断key是否在map中
        if (map.containsKey(key)) {
            // 是 修改
            // 修改node的值 提升优先级
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            appendHead(node);
            return;
        }
        // 否 增加
        // 判断是否到了容量
        int n = map.size();
        Node node = new Node(key, value);
        // 到了容量 逐出最后一个节点 逐出map中的key
        if (n >= capacity) {
            Node lastNode = tail.pre;
            map.remove(lastNode.key);
            removeNode(lastNode);
        }
        // 添加到链表中， 添加到map中
        appendHead(node);
        map.put(key, node);
    }

    public static void main(String[] args) {
        LRUCache_ test = new LRUCache_(2);
        test.put(1, 1);
        test.put(2, 2);
        System.out.println(test.get(1)); // 1
        test.put(3, 3);
        System.out.println(test.get(2)); // -1
        test.put(4, 4);
        System.out.println(test.get(1)); // -1
        System.out.println(test.get(3)); // 3
        System.out.println(test.get(4)); // 4
    }
}
