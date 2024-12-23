package com.wjw.queue;

/*
使用数组实现循环队列（内存上使用循环的数组，节省内存空间）
这里队列满了不扩队列
void push(E e)
E pop()
E peek()
E peekLast()
int size()
boolean isEmpty()
boolean isFull()
 */
public class ArrayQueue<E> {
    private E[] data;
    private int first;
    private int last;
    private int size;
    private static final int INIT_CAP = 2;

    public ArrayQueue() {
        this(INIT_CAP);
    }

    public ArrayQueue(int initCap) {
        data = (E[]) new Object[initCap];
        first = last = 0;
        size = 0;
    }

    public void push(E e) {
        if (isFull()) {
            throw new RuntimeException("队列已经满了，不可以继续添加元素!");
        }
        data[last] = e;
        last++; // last = 0 ~ n - 1
        if (last == data.length) {
            last = 0;
        }
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不可以弹出元素!");
        }
        E val = data[first];
        data[first] = null;
        first++;
        if (first == data.length) {
            first = 0;
        }
        size--;
        return val;
    }

    // 查看开头元素
    public E peek() {
        return data[first];
    }

    // 查看末尾元素
    public E peekLast() {
        if (last == 0) return data[data.length - 1];
        return data[last - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> aq = new ArrayQueue<>(3);
        aq.push(1);
        aq.push(2);
        aq.push(3);
//        aq.push(4);
        System.out.println(aq.pop()); // 1
        System.out.println(aq.pop()); // 2
        System.out.println(aq.size()); // 1
        System.out.println(aq.peekLast()); // 3
        System.out.println(aq.peek()); // 3
        System.out.println(aq.pop()); // 3
        System.out.println(aq.size()); // 0

    }
}
