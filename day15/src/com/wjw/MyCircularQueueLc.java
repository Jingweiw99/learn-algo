package com.wjw;

/*
lc622设计循环链表

 */
public class MyCircularQueueLc {
    private int[] data;
    private int size;
    private int first;
    private int last;
    private final int capacity;

    public MyCircularQueueLc(int k) { // 容量由k决定
        data = new int[k];
        this.capacity = k;
        this.size = 0;
        first = last = 0;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        data[last % capacity] = value;
        last++; // first last一直加取值的时候%
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        data[first % capacity] = -1;
        first++;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[first % capacity];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[(last - 1) % capacity]; // last是每一次修改的位置，要找到最后一个，需要-1，然后再找
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}


