package com.wjw;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/*
n皇后问题
请你返回n皇后的所有的可能得解
 */
public class Lc51 {
    List<List<String>> res = new ArrayList<>();
    List<String> track = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        for (int i = 0; i < n; i++) {
            List<String> innerList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                innerList.add(".");
            }
            res.add(innerList);
        }
        backtrack(n, 0);
        return res;
    }

    private void backtrack(int n, int start) {
        if (start == n) {

            return;
        }
        for (int i = start; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isPlace(res, i, j)) {
                    continue;
                }
                res.get(i).set(j, "Q");
                backtrack(n, start + 1);
                res.get(i).set(j, ".");
            }
        }
    }

    // 判断res能否摆在 i , j 位置
    private boolean isPlace(List<List<String>> res, int i, int j) {
        // 斜左上 上面 斜右上
        for (int k = i - 1; k >= 0; k--) {
            for (int l = 0; l < res.size(); l++) {
                // 如果这个位置上是Q，判断是否是三个方向上的，返回false  遍历结束直接返回true
                if (res.get(k).get(l).equals("Q")) {
                    if (j - l == Math.abs(i - k) || l == j)
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Lc51 test = new Lc51();
        System.out.println(test.solveNQueens(4));
    }
}
