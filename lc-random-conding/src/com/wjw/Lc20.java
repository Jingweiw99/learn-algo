package com.wjw;

import java.util.Stack;

/*
有效的括号
每一个左括号必须与右括号闭合
将字符串转换为字符数组，然后加入到栈中
如果是碰到了匹配的左括号可以弹出来，
判断枚举玩chars是否为空，是：true 否false
 */
public class Lc20 {
    public boolean isValid(String s) {
        if (s.length() <= 1) return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            // ch是左括号直接放入
            if (isLeft(ch)) {
                stack.push(ch);
                continue;
            }
            // ch是右括号 判断有无匹配的左括号
            if (stack.isEmpty()) return false;
            if (ch == ')' && stack.peek() != '(') return false;
            if (ch == ']' && stack.peek() != '[') return false;
            if (ch == '}' && stack.peek() != '{') return false;
            // 无： 返回false
            stack.pop();
            // 有：弹出左括号
        }
        return stack.isEmpty() ? true : false;
    }

    // 判断ch是不是'(' '[' '{'
    private boolean isLeft(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    public static void main(String[] args) {
        Lc20 test = new Lc20();
        System.out.println(test.isValid("){"));
    }
}
