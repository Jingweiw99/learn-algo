package com.wjw.hard;

import java.util.HashMap;
import java.util.Stack;

/*
实现一个计算器
版本1 包含加减乘除 和空格
版本2 包含加减乘除 空格 和 ( )
版本2的思考 在版本1的基础上版本2其实是递归  cal2("1 + 2 + (3 * 3)")  = 1 + 2 + cal1("3 * 3") 多个括号也是这样
s = " 1 + 2 * 3 / 3"  3
 */
public class Calculate {
    // 版本1
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                int pre;
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Calculate test = new Calculate();
//        System.out.println(test.calculate(" 1 +3 - 2")); // 2
//        System.out.println(test.calculate(" 1 +3 - 2 / 2 * 1")); // 3

        System.out.println(test.calculate_("1+2*(3 + 4) ")); // 15
        System.out.println(test.calculate_(" 2/ 1   *(2 + 1) "));// 6
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    // 版本2
    public int calculate_(String s) {
        // 搜先需要找到多个括号 左括号对右括号的映射
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                map.put(stack.pop(), i);
            }
        }
        return calculateHelp(s, 0, s.length() - 1);
    }

    // 字符串s，在[start, end] 上计算结果，并返回
    private int calculateHelp(String s, int start, int end) {
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                int rightIndex = map.get(i);
                num = calculateHelp(s, i + 1, rightIndex - 1);
                i = rightIndex;
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == end) {
                int pre;
                switch (sign) {
                    case '+':
                        numStack.push(num);
                        break;
                    case '-':
                        numStack.push(-num);
                        break;
                    case '*':
                        pre = numStack.pop();
                        numStack.push(pre * num);
                        break;
                    case '/':
                        pre = numStack.pop();
                        numStack.push(pre / num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!numStack.isEmpty()) {
            res += numStack.pop();
        }
        return res;
    }
}
