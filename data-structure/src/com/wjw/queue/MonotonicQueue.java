package com.wjw.queue;

import java.util.LinkedList;

/*
单调队列
 */
public class MonotonicQueue<E extends Comparable<E>> {
    LinkedList<E> q = new LinkedList<>();
    LinkedList<E> maxq = new LinkedList<>();
    LinkedList<E> minq = new LinkedList<>();

    public void push(E elem) {
        q.addLast(elem);

        while (!maxq.isEmpty() && maxq.getLast().compareTo(elem) < 0) {
            maxq.pollLast();
        }
        maxq.addLast(elem);

        while (!minq.isEmpty() && minq.getLast().compareTo(elem) > 0) {
            minq.pollLast();
        }
        minq.addLast(elem);
    }

    public E max() {
        return maxq.getFirst();
    }

    public E min() {
        return minq.getFirst();
    }

    public E pop() {
        E deleteVal = q.pollFirst(); // 弹出的值是正常队列的值
        assert deleteVal != null;
        if (deleteVal.equals(maxq.getFirst())) {
            maxq.pollFirst();
        }
        if (deleteVal.equals(minq.getFirst())) {
            minq.pollFirst();
        }
        return deleteVal;
    }

    public int size() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
}
