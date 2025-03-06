package com.wjw;

/*
环形数组通过模运算可以在O(1)的时间，删除和添加头部元素
因为就地删除，修改元素。通过模运算
 */
public class CycleArray<T> {
    private T[] arr;
    private int start; // 第一个有效  元素
    private int end;
    private int count;
    private int size;

    public CycleArray() {
        this(1);
    }

    public CycleArray(int size) {
        this.size = size;
        // Java不支持直接创建泛型数组
        this.arr = (T[]) new Object[size];
        // 指向第一个有效元素的索引，闭区间
        this.start = 0;
        // 最后一个有效元素的下一个位置索引
        this.end = 0;
        this.count = 0;
    }

    // 数组头部添加元素
    public void addFirst(T val) {
        if (isFull()) {
            resize(size * 2);
        }
        start = (start - 1 + size) % size;
        arr[start] = val;
        count++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Array is empty");
        }
        // 开头设置为空start往右移
        arr[start] = null;
        start = (start + 1) % size;
        count--;
        // 如果数组数量减少到原大小的四分之一，减小数组大小为一半
        if (count > 0 && count == size % 4) {
            resize(size / 2);
        }
    }

    public void addLast(T val) {
        if (isFull()) {
            resize(size * 2);
        }
        arr[end] = val;
        end = (end + 1) % size;
        count++;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Array is empty");
        }
        end = (end - 1 + size) % size;
        arr[end] = null;
        count--;
        if (count > 0 && count == size / 4) {
            resize(size / 2);
        }
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Array is empty");
        }
        return arr[start];
    }

    public T getLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Array is empty");
        }
        return arr[(end - 1 + size) % size];
    }


    private boolean isEmpty() {
        return count == 0;
    }


    private boolean isFull() {
        return count == size;
    }

    private void resize(int newSize) {
        T[] newArr = (T[]) new Object[newSize];
        for (int i = 0; i < count; i++) {
            newArr[i] = arr[(start + i) % size]; // newArr可以直接按顺序，原先的通过取余获取让后放入
        }
        arr = newArr;
        start = 0;
        end = count;
        size = newSize;
    }

}
