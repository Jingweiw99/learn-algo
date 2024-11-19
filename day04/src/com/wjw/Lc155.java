package com.wjw;

import java.util.Stack;

/*
最小栈
https://leetcode.cn/problems/min-stack/
 */
public class Lc155 {
    /*
     * 思路可以做两个栈，一个普通的Stack 一个minStack保存最小值
     * push的时候min-stack push最小值（要push的数和minStack头部的最小值） 同时push这个数
     * pop的时候可以弹出这个minStack和stack
     * top直接查看这个栈顶元素
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Lc155() {
        this.minStack = new Stack<Integer>();
        this.stack = new Stack<Integer>();
    }

    public void push(int val) {
        // 考虑边界
        if(minStack.empty()) {
            minStack.push(val);
            stack.push(val);
            return;
        }
        // 一般情况下 找push的值和minStack栈顶最小值
        stack.push(val);
        val = val <= minStack.peek() ? val : minStack.peek();
        minStack.push(val);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
