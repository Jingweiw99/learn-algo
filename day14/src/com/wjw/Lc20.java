package com.wjw;

import java.util.Stack;

/*
 有效的括号
 */
public class Lc20 {
    public static boolean isValid(String str) {
        // 给一个栈stack用于存放左括号，如果碰到右括号，不是匹配的那就 false，如果是继续，跳出循环就是true
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) { // 注意这个和return的边界情况
                return false;
            }
            char leftKh = stack.pop();
            if (!isPp(leftKh, c)) {
                return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }

    private static boolean isPp(char left, char right) {
        if (left == '(') {
            if (right != ')') return false;
        } else if (left == '[') {
            if (right != ']') return false;
        } else if (left == '{') {
            if (right != '}') return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        boolean res = isValid("(){}[]");
        boolean res = isValid("(){[}]");
        System.out.println(res);
    }
}
