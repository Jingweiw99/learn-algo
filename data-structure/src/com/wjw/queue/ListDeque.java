package com.wjw.queue;

import java.util.NoSuchElementException;

/*
使用链表实现队列
也没考虑队列的容量
添加头 void addFirst(E e)
添加尾 void addLast(E e)
获取头 E getFirst()
获取尾 E getLast()
删除头 E removeFirst()
删除尾 E removeLast()
size()
isEmpty()
 */
public class ListDeque<E> {
    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;

        Node(E val) {
            this.val = val;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size;

    public ListDeque() {
        first = null;
        last = null;
        size = 0;
    }

    public void addFirst(E e) {
        Node node = new Node(e);
        if (first == null) {
            first = last = node;
        } else {
            first.prev = node;
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(E e) {
        Node node = new Node(e);
        if (last == null) {
            first = last = node;
        } else {
            node.prev = last;
            last.next = node;
            last = node;
        }
        size++;
    }

    public E getFirst() {
        return first.val;
    }

    public E getLast() {
        return last.val;
    }

    public E removeFirst() {
        // 如果是isEmpty 报错
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E val = first.val;
        Node firstNext = first.next;
        first.next = null; // 多加一步这个位置Java可以省略
        firstNext.prev = null;
        first = firstNext;
        size--;
        return val;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E val = last.val;
        Node preLast = last.prev;
        preLast.next = null;
        last = preLast;
        size--;
        return val;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        ListDeque<Integer> dq = new ListDeque<>();
        dq.addLast(1);
        dq.addLast(2);
        dq.addFirst(3); // 从左到右现在是  2 1 3
        System.out.println(dq.size()); // 3
        System.out.println(dq.removeFirst()); // 3
        System.out.println(dq.removeLast()); // 2
        System.out.println(dq.getFirst()); // 1
        System.out.println(dq.getLast()); // 1
        System.out.println(dq.size()); // 1
    }

}
