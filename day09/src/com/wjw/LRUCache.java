package com.wjw;

import java.util.HashMap;

/*
最少最近缓存


 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        this.tail = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        // 获取key， 如果不存在返回-1， 如果存在获取值返回
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 还需要加上提升优先级  删除当前节点， 然后放到head后面
        Node curNode = cache.get(key);
        removeNode(curNode);
        appendHead(curNode);
        return curNode.value;
    }

    private void appendHead(Node curNode) {
        // 先找到head的下一个节点headNext  head.next = curNode  curNode.prev = head  curNode.next = headNext headNext.prev = curNode;
        Node headNext = head.next;
        head.next = curNode;
        curNode.prev = head;
        curNode.next = headNext;
        headNext.prev = curNode;
    }

    private void removeNode(Node curNode) {
        // 找到这个节点的前节点，后节点，让后节点的prev指向前节点， 前节点的next指向后节点
        curNode.next.prev = curNode.prev;
        curNode.prev.next = curNode.next;
    }

    public void put(int key, int value) {
        // 修改和增加两种情况
        if (cache.containsKey(key)) {
            // 修改 修改值，先后提优先级
            Node cur = cache.get(key);
            cur.value = value;
            removeNode(cur);
            appendHead(cur);
        } else {
            // 增加 没到容量， 到了容量
//            if (cache.size() < capacity) {
//                Node cur = new Node(key, value);
//                appendHead(cur);
//                cache.put(key, cur);
//            } else {
//                // 到了容量 删除tail前面一个节点，和cache中
//                // 然后将新的放入到
//                cache.remove(tail.prev.key);
//                removeNode(tail.prev);
//                Node cur = new Node(key, value);
//                appendHead(cur);
//                cache.put(key, cur);
//            }
            // 这里两种想法： 上面没简化的是通过容量来分情况。 下面是按照过程，先判断超过容量了就移出，然后添加
            if(cache.size() >= capacity) {
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            Node cur = new Node(key, value);
            appendHead(cur);
            cache.put(key, cur);
        }
    }
}
