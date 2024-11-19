package com.wjw;

import java.util.Stack;

public class Lc150 {
    public static int evalRPN(String[] tokens) {
        // 大体思路是放一个栈碰到数字直接放入，碰到的是运算符弹出两个然后计算
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!isOp(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calc(a, b, token));
            }
        }
        return stack.peek();
    }

    private static boolean isOp(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }

    private static int calc(int a, int b, String token) {
        if (token == "+")
            return a + b;
        if (token == "-")
            return a - b;
        if (token == "*")
            return a * b;
        if (token == "/")
            return a / b;
        return 0;
    }

    public static void main(String[] args) {
        String[] strArr = new String[]{"2", "1", "+"};
        int i = evalRPN(strArr);
        System.out.println(i);
    }
}
