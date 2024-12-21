package com.wjw;

import java.util.LinkedList;
import java.util.Queue;

/*
使用队列去实现一个栈 Lc225
 */
public class MyStack {
    private Queue<Integer> queue;
    private Integer lastEle;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        // push的时候直接push进去
        queue.offer(x);
        lastEle = x;
    }

    public int pop() {
        // 将laseEle前面的元素全部放到这个元素后面， 然后弹出这个元素
//        Integer preLstEle = lastEle;
//        while (!preLstEle.equals(queue.peek())) {
//            push(queue.poll());
//        }
//        Integer res = queue.poll();
//        //
//        return res;
        int size = queue.size();
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }
        lastEle = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }

    public int top() {
        return lastEle;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top()); // 2
        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1
    }
}
