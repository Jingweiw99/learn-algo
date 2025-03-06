package com.wjw;

import java.util.LinkedList;
import java.util.Stack;

/*
逆波兰表达式求值 这里的有效符号是 + - * /
核心思路：
遍历tokens，给一个栈，
判断是否是符号，
否：添加到栈中
是：弹出两个 运算  push到栈中
 */
public class Lc150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (!isFh(token)) {
                stack.push(token);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop()); // 后弹出来的是第一个计算的数
                int evalVal = eval(token, num1, num2);
                stack.push(evalVal + "");
            }
        }
        return Integer.parseInt(stack.peek());
    }

    private int eval(String fh, int num1, int num2) {
        int res = 0;
        switch (fh) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
        }
        return res;
    }

    // 给一个字符串，判断是否是符号
    private boolean isFh(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }


    public static void main(String[] args) {
        String[] strs = {"4","13","5","/","+"};
        Lc150 test = new Lc150();
        System.out.println("最后执行的结果是: " + test.evalRPN(strs));
    }
}
