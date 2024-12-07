package com.wjw;

import java.util.ArrayList;
import java.util.List;

/*
测试lc22 括号生成debug
 */
public class Test1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        
        sb.deleteCharAt(sb.length()-1);
        Test1 test = new Test1();
        test.generateParenthesis(1);
    }
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        // 记录所有合法的括号组合
        List<String> res = new ArrayList<>();
        // 回溯过程中的路径
        StringBuilder track = new StringBuilder();
        // 可用的左括号和右括号数量初始化为 n
        backtrack(n, n, track, res);
        return res;
    }

    // 可用的左括号数量为 left 个，可用的右括号数量为 right 个
    private void backtrack(int left, int right, StringBuilder track, List<String> res) {
        // 若左括号剩下的多，说明不合法
        if (right < left) return;
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) {
            System.out.println(left + " " + right);
            return;
        }
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }

        // 尝试放一个左括号
        // 选择
        track.append('(');
        backtrack(left - 1, right, track, res);
        // 撤消选择
        track.deleteCharAt(track.length() - 1);

        // 尝试放一个右括号
        // 选择
        track.append(')');
        backtrack(left, right - 1, track, res);
        // 撤消选择
        track.deleteCharAt(track.length() - 1);
    }
}
