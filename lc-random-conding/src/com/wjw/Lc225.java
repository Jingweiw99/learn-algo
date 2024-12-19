package com.wjw;

import java.util.LinkedList;
import java.util.Queue;

/*
使用队列实现栈
push pop top empty
 */
public class Lc225 {
    Queue<Integer> q;
    int lastEle;

    public Lc225() {
        this.q = new LinkedList<>();
    }

    public void push(int val) {
        q.offer(val);
        lastEle = val;
    }

    public int top() {
        return lastEle;
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public int pop() {
        // 先pop size - 1次，然后全push到最后一个元素后面，然后poll出这个元素
//        if(q.size() == 1) return q.poll();
//        for(int i = 1; i< q.size(); i++) {
//            q.offer(q.poll());
//        }
//        return q.poll();

        // 或者这样
        int size = q.size();
        while (size > 1) {
            q.offer(q.poll());
            size--;
        }
        return q.poll();
    }

    public static void main(String[] args) {
        Lc225 test = new Lc225();
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.top()); // 3
        System.out.println(test.pop()); // 3
        System.out.println(test.pop()); // 2
        System.out.println(test.empty()); // false
        System.out.println(test.pop()); // 1
        System.out.println(test.empty()); // true
    }
}
