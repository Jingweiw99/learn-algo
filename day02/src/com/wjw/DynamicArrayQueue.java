package com.wjw;

import java.util.ArrayList;


/*
DynamicArrayQueue： 动态数组实现的队列结构
enqueue 入栈操作
dequeue 出栈操作
peek  查看队首元素
isEmpty 判断队列是否为空
size 获取队列的大小
 */
public class DynamicArrayQueue<T> {
    public ArrayList<T> queue;
    private int size;

    DynamicArrayQueue() {
        queue = new ArrayList<>();
        size = 0;
    }

    public void enqueue(T value) {
        queue.add(value);
        size++;
    }

    public T dequeue() {
        T res = queue.remove(0);
        size--;
        return res;
    }

    public T peek() {
        return queue.get(0);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        DynamicArrayQueue<Integer> queue = new DynamicArrayQueue<>();
        // 1. 验证入栈
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        print(queue);
        // 2. 验证出栈
        Integer num = queue.dequeue();
        System.out.println(num);
        // 3. 验证peek
        System.out.println(queue.peek());
        // 4. 验证isEmpty size
        queue.dequeue();
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        queue.dequeue();
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
    }

    public static void print(DynamicArrayQueue<Integer> queue) {
        for (Integer num : queue.queue) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
