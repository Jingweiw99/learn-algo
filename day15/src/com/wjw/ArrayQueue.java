package com.wjw;

import java.util.NoSuchElementException;

/*
使用数组实现循环队列
需要考虑容量 这里给了扩容
 */
public class ArrayQueue<E> {
    private int size;
    private E[] data;
    private static final int INIT_CAP = 2;

    private int first, last;

    public ArrayQueue() {
        this(INIT_CAP);
    }

    public ArrayQueue(int initCap) {
        size = 0;
        data = (E[]) new Object[initCap];
        first = last = 0; // 在进入enqueue和dequeue两个都对应的需要操作的索引
    }

    public void enqueue(E e) {
        if (size == data.length) {
            resize(size * 2);
        }
        data[last] = e;
        last++;
        if (last == data.length) {
            last = 0;
        }
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size == data.length / 4) {
            resize(data.length / 2);
        }
        E oldVal = data[first];
        data[first] = null;
        first++;
        if (first == data.length) {
            first = 0;
        }
        size--;
        return oldVal;
    }

    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];
        for (int i = 0; i < size; i++) {
            temp[i] = data[(first + i) % data.length];
        }
        first = 0;
        last = size;
        data = temp;
    }


    public E peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return data[first];
    }

    public E peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (last == 0) return data[data.length - 1];
        return data[last - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> aq = new ArrayQueue<>(3);
        aq.enqueue(1);
        aq.enqueue(2);
        aq.enqueue(3);
        aq.enqueue(4);
        System.out.println(aq.dequeue());  // 1
        System.out.println(aq.peekFirst()); // 2
        System.out.println(aq.peekLast()); // 4
    }
}
