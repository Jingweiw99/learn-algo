package com.wjw;

import java.util.Stack;

/*
最小栈 MinStack
这里最简单的思路就是 添加一个最小栈每次 push pop的时候也更新最小栈， getMin的时候直接minStack.peek()

pop、top 和 getMin 操作总是在 非空栈 上调用
 */
public class Lc155 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Lc155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        // stack push进去数据 minStack判断当前的数是否小于 栈顶元素 是：push这个数 否：push栈顶元素
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
            return;
        }
        int topVal = minStack.peek();
        if (val < topVal) {
            minStack.push(val);
        } else {
            minStack.push(topVal);
        }
    }

    public void pop() {
        // 首先弹出stack  minStack也直接弹出
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    // 获取栈中的最小元素，要求时间复杂度是O（1）
    public int getMin() {
        return minStack.peek();
    }
}
