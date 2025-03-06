package com.wjw.Array;


/*
使用数组实现动态数组
实现扩容和缩容 如果到了容量，扩容为原来的两倍 如果到了到了1/4，缩容为原来的1/2
接口如下
void add(int index, E e)
void addLast(E e)
void addFirst(E e)
E remove(int index)
E removeFirst()
E get(int index)
void set(int index, E element)
int size()
boolean isEmpty()
void resize(int newCap)
 */
public class MyArrayList<E> {
    private E[] data;
    private int size;
    private static final int INIT_CAPACITY = 10;

    public MyArrayList() {
        this(INIT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public void add(int index, E e) {
        // 判断是否越界了 是：throw错误 否：添加上
        checkIsYuejie(index);
        // 判断数组是否满了 是：扩容，否：   添加上数组
        if (data.length == size) {
            resize(size * 2);
        }
        // size index + 1
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size - 1, e);
    }

    public E remove(int index) {
        checkIsYuejie(index);
        if (size == data.length / 4) {
            resize(data.length / 2);
        }
        E e = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E get(int index) {
        checkIsYuejie(index);
        return data[index];
    }

    public void set(int index, E e) {
        checkIsYuejie(index);
        data[index] = e;
    }

    // 将data 扩容 为大小为n的数组
    private void resize(int n) {
        // 创建新的容量大小为n的数组 将原数组的数据添加到新数组中 将指针指向新数组
        E[] newData = (E[]) new Object[n];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIsYuejie(int index) {
        if (!(index >= 0 && index <= data.length - 1)) {
            throw new IndexOutOfBoundsException(index + "越界了！");
        }
    }
}
