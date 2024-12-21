package com.wjw;

import java.util.NoSuchElementException;

/*
使用数组实现双端队列
数组需要给容量，考虑扩缩容问题
 */
public class MyArrayDeque<E> {
    private int size;
    private E[] data;
    private final static int INIT_CAP = 2;

    private int first, last;

    public MyArrayDeque() {
        this(INIT_CAP);
    }

    public MyArrayDeque(int initCap) {
        size = 0;
        data = (E[]) new Object[initCap];
        first = last = 0;
    }

    // 从头部获取元素
    public E getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return data[first];
    }

    public E getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        if (last == 0) return data[data.length - 1];
        return data[last - 1];
    }

    public void addFirst(E e) {
        if (size == data.length) {
            resize(size * 2);
        }
        if (first == 0) {
            first = data.length - 1;
        } else {
            first--;
        }
        data[first] = e;
        size++;
    }

    // 从尾部插入元素
    public void addLast(E e) {
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

    // 从头部删除元素
    public E removeFirst() {
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

    // 从尾部删除元素
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size == data.length / 4) {
            resize(data.length / 2);
        }
        // 删除应该左移，索引0的元素-- 回到最后一个
        if (last == 0) {
            last = data.length - 1;
        } else {
            last--;
        }
        E oldVal = data[last];
        data[last] = null;
        size--;
        return oldVal;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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

    public static void main(String[] args) {
        // 测试添加头尾部，获取头尾部，删除头尾部
        MyArrayDeque<Integer> deque = new MyArrayDeque<>();
        deque.addFirst(2);
        deque.addLast(3);
        deque.addFirst(1);
        System.out.println(deque.getFirst()); // 1
        System.out.println(deque.getLast()); // 3
        System.out.println(deque.removeFirst()); // 1
        System.out.println(deque.removeLast()); // 3
        System.out.println(deque.getFirst()); // 2
    }

}
