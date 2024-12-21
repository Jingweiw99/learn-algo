package com.wjw;

import java.util.Stack;

/*
在常数时间获取栈的最小值
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        // 如果stack是空，那么push val minStack也push val
        if (stack.isEmpty()) {
            stack.push(val);
            minStack.push(val);
        } else {
            stack.push(val);
            if (val < minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        // pop的时候 弹出stack和minStack的
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
