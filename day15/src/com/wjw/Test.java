package com.wjw;

import java.util.Deque;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.add(1);
        dq.addLast(2);
        dq.addFirst(3); // 2 1 3
        System.out.println(dq.pollLast()); // 2  队列变为 1 3
        System.out.println(dq.pollFirst()); // 3 队列变为 1
        System.out.println(dq.peek()); // 1
    }
}
