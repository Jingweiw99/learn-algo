package com.wjw.queue;

/*
使用链表实现队列
考虑队列的容量
void push(E e)
E pop()
E peek()
E peekLast()
int size()
boolean isEmpty()
boolean isFull()
 */
public class ListQueue<E> {


    private static class Node<E> {
        E val;
        Node<E> next;

        Node(E val) {
            this.val = val;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size;
    private int capacity;
    private static final int INIT_CAP = 10; // 默认队列大小为10

    public ListQueue() {
        this(INIT_CAP);
    }

    public ListQueue(int initCap) {
        first = last = null;
        size = 0;
        capacity = initCap;
    }

    public void push(E e) {
        // 容量满了
        if (isFull()) {
            throw new RuntimeException("队列容量满了，不可再添加！");
        }
        // 容量没满
        Node node = new Node(e);
        if (last == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不可再弹出");
        }
        E val = first.val;
        Node firstNext = first.next;
        first.next = null;
        first = firstNext;
        size--;
        return val;
    }

    public E peek() {
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

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        ListQueue<Integer> lq = new ListQueue<>(3);
        lq.push(1);
        lq.push(2);
        lq.push(3);
//        lq.push(3);
        System.out.println(lq.peek());//1
        System.out.println(lq.peekLast()); // 3
        System.out.println(lq.pop());// 1
        System.out.println(lq.pop());// 2
        System.out.println(lq.size()); // 1
    }
}
