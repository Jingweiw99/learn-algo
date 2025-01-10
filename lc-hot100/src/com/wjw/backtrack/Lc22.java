package com.wjw.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
括号生成
想到 限制左右括号的数量
 */
public class Lc22 {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        traverse(n, n);
        return res;
    }

    // left 表示左括号还可以剩余多少 right同理
    private void traverse(int left, int right) {
        if (left < 0 || right < 0) return;
        if (left > right) return;
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        sb.append('(');
        traverse(left - 1, right);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        traverse(left, right - 1);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        Lc22 test = new Lc22();
        List<String> strings = test.generateParenthesis(3);
        System.out.println(strings);
    }
}
