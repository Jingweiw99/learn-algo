package com.wjw;


// 使用单向链表实现 队列 先进先出的数据结构
public class NodeQueue<V> {
    private Node<V> head;
    private Node<V> tail;
    private int size;

    public NodeQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    class Node<V> {
        public V value;
        public Node<V> next;

        Node(V value) {
            this.value = value;
        }
    }

    /*
    下面实现 isEmpty size
    enqueue 接受一个value添加进去
    dequeue 出栈
    peek 查看首元素
    isEmpty
    size
     */
    public void enqueue(V value) {
        Node<V> cur = new Node<>(value);
        if (tail == null) {
            head = cur;
            tail = cur;
        } else {
            tail.next = cur;
            tail = cur;
        }
        size++;
    }

    // 出栈需要返回对应的值
    public V dequeue() {
        V ans = null;
        if (head != null) {
            ans = head.value;
            head = head.next;
            size--;
        }
        // 只有一个并且出栈的时候
        if (head == null) {
            tail = null;
        }
        return ans;
    }

    public V peek() {
        V ans = null;
        if (head != null) {
            ans = head.value;
        }
        return ans;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


}
