package com.wjw.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
n皇后问题
返回全部的解
 */
public class Lc51 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] qp = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(qp[i], '.');
        }
        backtrack(0, qp);
        return res;
    }

    private void backtrack(int row, char[][] qp) {
        if (row == qp.length) {
            ArrayList<String> list = new ArrayList<>();
            for (char[] row1 : qp) {
                list.add(new String(row1));
            }
            res.add(list);
            return;
        }
        for (int col = 0; col < qp.length; col++) {
            if (!isValid(qp, row, col)) continue;
            qp[row][col] = 'Q';
            backtrack(row + 1, qp);
            qp[row][col] = '.';
        }
    }

    // qp 的 i j位置能否摆放皇后
    private boolean isValid(char[][] qp, int row, int col) {
        // 上 左上方  右上方 有则返回false
        for (int i = 0; i < row; i++) {
            if (qp[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (qp[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < qp.length; i--, j++) {
            if (qp[i][j] == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Lc51 test = new Lc51();
        System.out.println(test.solveNQueens(4));
    }
}

