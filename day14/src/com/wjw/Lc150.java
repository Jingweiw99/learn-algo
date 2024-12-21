package com.wjw;

import java.util.Stack;

public class Lc150 {
    public static int evalRPN(String[] tokens) {
        // 给一个栈，存放波兰表达式的值，每次碰到运算符，就弹出两个，后弹出来的操作前一个
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            // 如果是数字，push
            if (!isFh(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                // 如果是符号 进行操作
                int right = stack.pop();
                if (stack.isEmpty()) { // 是一个正确的表达式不会到这一步 比如先1 在+ 通过测试用例可以省略这个判断。
                    return right;
                }
                int left = stack.pop();
                int calVal = eval(left, right, token);
                stack.push(calVal);
            }
        }
        return stack.pop();
    }

    private static int eval(int left, int right, String str) {
        int res = 0;
        if (str.equals("+")) {
            res = left + right;
        } else if (str.equals("-")) {
            res = left - right;
        } else if (str.equals("*")) {
            res = left * right;
        } else if (str.equals("/")) {
            res = left / right;
        }
        return res;
    }

    private static boolean isFh(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        }
        return false; // 不是符号就是数字
    }
}
