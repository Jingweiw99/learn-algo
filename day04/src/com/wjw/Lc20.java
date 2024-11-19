package com.wjw;

import java.util.Stack;

/*
有效的括号
https://leetcode.cn/problems/valid-parentheses/
 */
public class Lc20 {
    /*
    可以通过但是4ms
     */
    public boolean isValid1(String s) {
        // 放入一个栈，如果碰到匹配的，出栈。
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
                continue;
            }
            if (stack.peek() == '[' && s.charAt(i) == ']') {
                stack.pop();
                continue;
            }
            if (stack.peek() == '{' && s.charAt(i) == '}') {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.empty();
    }

    /*
    思路：
    左括号直接加入栈，右括号判断
    如果全部遍历结束之后，返回true
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) return false;
                if (s.charAt(i) == ')') {
                    if (stack.peek() != '(') return false;
                } else if (s.charAt(i) == ']') {
                    if (stack.peek() != '[') return false;
                } else if (s.charAt(i) == '}') {
                    if (stack.peek() != '{') return false;
                }
                // 这里配对到了要pop
                stack.pop();
            }
        }
        return stack.empty();
    }
}
