package com.wjw.NQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
N皇后问题
n皇后的解决方案，并返回
 */
public class Lc51 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>(); // 单次摆放的结果
        for (int i = 0; i < n; i++) {
            char[] cs = new char[n];
            Arrays.fill(cs, '.');
            board.add(new String(cs));
        }
        backtrack(board, 0); // 每一次回溯到底会得到一次结果， 每次到底添加这次结果
        return res;
    }

    private void backtrack(List<String> board, int row) {
        int n = board.size();
        if (row == n) {
            // 保存当时的board
            res.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) continue;
            char[] chars = board.get(row).toCharArray();
            chars[col] = 'Q';
            board.set(row, new String(chars));

            backtrack(board, row + 1);

            chars[col] = '.';
            board.set(row, new String(chars));
        }
    }

    // 判断board上，row，col是否可以摆放Q
    private boolean isValid(List<String> board, int row, int col) {
        // 判断row上面的行对应的col是否有Q
        // 判断row上面的行对应的斜角是否有Q
        int n = board.size();
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') return false;
        }
        for (int j = row - 1, k = col - 1; j >= 0 && k >= 0; j--, k--) {
            if (board.get(j).charAt(k) == 'Q') return false;
        }
        for (int j = row - 1, k = col + 1; j >= 0 && k < n; j--, k++) {
            if (board.get(j).charAt(k) == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Lc51 test = new Lc51();
        List<List<String>> lists = test.solveNQueens(4);
        System.out.println(lists);
    }
}
