package com.wjw;

import java.util.HashMap;
import java.util.Stack;

/*
实现一个计算器
这里只需要实现+ - ( )
 */
public class Lc224 {
    public static int calculate(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else if (s.charAt(i) == ')') {
                map.put(stk.pop(), i);
            }
        }
        return _calculate(s, 0, s.length() - 1, map);
    }

    private static int _calculate(String s, int start, int end, HashMap<Integer, Integer> map) {
        // 先实现一个加减的不带空格的版本 空格 和 （） 其实可以不用处理
        Stack<Integer> stk = new Stack<>();
        char sign = '+'; // 需要判断的之前的符号
        int num = 0;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            // 找到取出来的数字
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            // 括号里面的值还是要先算、 不然，还是"1-(     -2)" 这种情况下有问题
            if (c == '(') {
                // 找到对应的右括号，然后递归调用结果
                int rightIndex = map.get(i);
                num = _calculate(s, i + 1, rightIndex - 1, map);
                i = rightIndex;
            }
            if (c == '+' || c == '-' || i == end) {
                if (sign == '+') {
                    stk.push(num);
                } else if (sign == '-') {
                    stk.push(-num);
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stk.isEmpty()) {
            res += stk.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1-(     -2)"));
    }
}
