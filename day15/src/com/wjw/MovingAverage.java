package com.wjw;

import java.util.LinkedList;
import java.util.Queue;

/*
移动平均值
 */
public class MovingAverage {
    private int maxSize;
    private Queue<Integer> q;
    private int sum = 0;

    public MovingAverage(int size) {
        maxSize = size;
        q = new LinkedList<>();
    }

    public double next(int val) {
        if (q.size() == maxSize) {
            sum -= q.poll();
        }
        q.offer(val);
        sum += val;
        return (double) sum / q.size();
    }
}
