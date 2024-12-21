package com.wjw;

import java.util.NoSuchElementException;

/*
使用链表实现队列
使用链表实现队列，没有容量限制（初始化链表不需要容量），不需要考虑循环队列的问题
 */
public class LinkedListQueue<E> {
    private static class Node<E> {
        E val;
        Node<E> next;

        Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }

    private int size;
    private Node<E> first;
    private Node<E> last;

    LinkedListQueue() {
        int size = 0;
    }

    public void enqueue(E e) {
        Node newNode = new Node<>(e, null);
        if (first == null) {
            first = newNode;
            first = last = newNode;
        } else {
            // 一般情况 last后面添加一个
            last.next = newNode;
            last = last.next;
        }
        size++;
    }

    public E dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E oldVal = first.val;
        first = first.next;
        size--;
        return oldVal;
    }

    public E peekFirst() {
        return first.val;
    }

    public E peekLast() {
        return last.val;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> q = new LinkedListQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());//1
        System.out.println(q.peekFirst());//2
        System.out.println(q.peekLast());//3
    }
}
