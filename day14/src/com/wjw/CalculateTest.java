package com.wjw;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
这里是实现一个计算器的 测试代码

实现一个计算器 包括 + - * / 和 ( ) 符号
传入字符串" ( 1+ 2 *(3 + 4 / 2))" 中间可以有空格
 */
public class CalculateTest {
    // 字符串转整数 自己实现 下面给出两种实现方式
    private static int toInt(String str) {
//        int res = 0;
//        int i = str.length();
//        for (char c : str.toCharArray()) {
//            int num = c - '0';
//            res += num * Math.pow(10, --i);
//        }
//        return res;
        int n = 0;
        for (char c : str.toCharArray()) {
            n = 10 * n + (c - '0');
        }
        return n;
    }

    private static Stack<Integer> stack = new Stack<>();

    // 如果只包含+ - 和数字，不包含空格和括号
    private static int cal(String str) {
        // 给一个|栈，放入带有符号的数字，最后全部相加
        char sign = '+';
        for (char c : str.toCharArray()) {
            if (isSign(c)) {
                sign = c;
            } else {
                // 这个是非符号，数字的情况
                int num = toNum(sign, c);
                stack.push(num);
            }
        }
        int res = 0;
        // 遍历结束之后最后一个个弹出来相加
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    // 让符号sign和组合带有符号的数字 这个方法不能单测
    private static int toNum(char sign, char c) {
        int num = c - '0';
        int pre;
        if (sign == '+') {
            num = +num;
        } else if (sign == '-') {
            num = -num;
        } else if (sign == '*') {
            pre = stack.pop(); // 这里空栈异常只能说明，之前没有乘数
            num = pre * num;
        } else if (sign == '/') {
            pre = stack.pop();
            num = pre / num;
        }
        return num;
    }

    private static boolean isSign(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') return true;
        return false;
    }


    public static void main(String[] args) {
//        int cal = cal("1+2+3*4/2");
//        System.out.println(cal);

        // 这里测试calculate
//        System.out.println(calculate("11+2-3+4"));
//        System.out.println(calculate("(1+2) /3 * 4")); // 向下取整
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 4);
        System.out.println(_calculate("(1+2) /3 * 4", 1, 3, map));
    }

    // 不带括号版的+-*/
    private static int calculate1(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            // 这里要注意， 找到符号的时候添加前面的符号和数字，然后更新符号，数字
            int preNum;
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        preNum = stack.pop();
                        stack.push(preNum * num); // 乘和除先计算
                    case '/':
                        preNum = stack.pop();
                        stack.push(preNum / num);
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

    public static int calculate(String s) {
        // 给一个栈存放num 方便之后计算
        // 处理括号的话实际上是一个递归过程，我们处理递归的区间、
        // 先找出左索引，对应的额右括号索引 保存下来
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
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

    // start ~ end 索引之间计算
    private static int _calculate(String s, int start, int end, Map<Integer, Integer> map) {
        int num = 0;
        char sign = '+';
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                // 找到这个右括号索引 然后递归计算 i rightIndex
                int rightIndex = map.get(i);
                num = _calculate(s, i + 1, rightIndex - 1, map);
                i = rightIndex;
            }
            int preNum;
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == end) {
                // push前面的符号和num
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        preNum = stack.pop();
                        stack.push(preNum * num);
                        break;
                    case '/':
                        preNum = stack.pop();
                        stack.push(preNum / num);
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
}
