package com.wjw;

/*
Java中栈和队列
Stack 栈
Queue 队列
Deque 双端队列 可以用LinkedList实现 Deque<String> deque = new LinkedList<>();
PriorityQueue 优先级队列
 */
public class Test {
    //
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            try {
                if(i == 99) {
                    System.out.println(i / 0);
                }
            } catch (Exception e) {
                System.out.println(1);
            }
            System.out.println(i);
        }
    }
}
