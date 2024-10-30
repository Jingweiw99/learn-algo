package com.wjw;

/*
使用链表实现栈
push
pop
peek
isEmpty
size
 */
public class LinkedStack {
    private Node head;
    private int size;

    private class Node {
        public Node next;
        public int value;

        Node(int value) {
            value = value;
        }
    }

    LinkedStack() {
        head = null;
        size = 0;
    }

    public void push(int value) {
        Node cur = new Node(value);
        if (head == null) {
            head = cur;
        } else {
            cur.next = head;
            head = cur;
        }
        size++;
    }

    public int pop() {
        int ans = Integer.parseInt(null);
        if (head != null) {
            ans = head.value;
            head = head.next;
            size--;
        }
        return ans;
    }
    public int peek() {
        return head != null ? head.value : null;
    }

}
