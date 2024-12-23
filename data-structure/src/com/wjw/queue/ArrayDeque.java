package com.wjw.queue;

import java.util.NoSuchElementException;

/*
使用纯数组实现双端队列，  如果使用动态数组，不能很好的控制循环队列
这里考虑扩缩容问题。
在添加之前到达了最大容量扩大为两倍，减少之前到达了1/4缩小为原来的两倍
默认初始容量给2 INIT_CAP

添加头 void addFirst(E e)
添加尾 void addLast(E e)
删除头 E removeFirst()
删除 尾 E removeLast
获取头 E getFirst
获取尾 E getLast
队列大小  int  size
是否满了 boolean  isFull
 */
public class ArrayDeque<E> {
    private E[] data;
    private int size;
    private int first;
    private int last;
    private static final int INIT_CAP = 2;

    public ArrayDeque() {
        this(INIT_CAP);
    }

    public ArrayDeque(int initCap) {
        data = (E[]) new Object[initCap];
        size = 0;
        first = last = 0;
    }

    // 添加头
    public void addFirst(E e) {
        checkIsFull();
        // 容量处理
        if (size == data.length) {
            resize(size * 2);
        }
        // 先-- 然后头指向
        if (first == 0) {
            first = data.length - 1;
        } else {
            first--;
        }
        data[first] = e;
        size++;
    }

    // 添加尾
    public void addLast(E e) {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不可删除！");
        }
        if (size == data.length) {
            resize(size * 2);
        }
        data[last] = e;
        if (last == data.length) {
            last = 0;
        } else {
            last++;
        }
        size++;
    }

    // 获取头
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return data[first];
    }

    // 获取尾
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (last == 0) return data[data.length - 1];
        return data[last - 1];
    }

    // 删除头
    public E removeFirst() {
        checkIsEmpty();
        if (size == data.length / 4) {
            resize(data.length / 2);
        }
        // 将first指针指向null然后++ 已经是最后了 回到0
        E oldVal = data[first];
        data[first] = null;
        if (first == data.length - 1) {
            first = 0;
        } else {
            first++;
        }
        size--;
        return oldVal;
    }

    // 删除尾
    public E removeLast() {
        checkIsEmpty();
        if (size == data.length / 4) {
            resize(data.length / 2);
        }
        // 将last指针--指向null 已经是0了 回到最后一个
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

    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 添加满了抛慢了的异常
    private void checkIsFull() {
        if (isFull()) {
            throw new RuntimeException("队列满了，不能添加！");
        }
    }

    // 删除是空的，抛空队列的异常
    private void checkIsEmpty() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不可删除！");
        }
    }

    // 扩缩容方法 需要修改data为新数组，放入数据，first和last重新指向。。 这里size可以是原来的，不用变
    private void resize(int newCap) {
        E[] newData = (E[]) new Object[newCap];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[(first + i) % data.length];
        }
        data = newData;
        first = 0;
        System.out.println("size:" + size);
        last = size;
    }

    public static void main(String[] args) throws Exception {
        ArrayDeque<Integer> ad = new ArrayDeque<>(4);
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addLast(3); // 2 1 null 3
        System.out.println(ad.removeFirst()); // 2
        System.out.println(ad.removeLast()); // 3

        System.out.println(ad.getFirst()); // 1
        System.out.println(ad.getLast()); // 1
    }


    public static void test1() {
        int[] nums = {3, -1, 2, 1};
        int first = 2, last = 1;
        int[] newArr = new int[8];
        for (int i = 0; i < nums.length; i++) {
            // 这里相当于所有的都左偏移（--）了first  做后的first直接指向size
            System.out.println(i + "  " + (i + first) % nums.length);
        }
    }

}
