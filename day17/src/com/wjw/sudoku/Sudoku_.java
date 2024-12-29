package com.wjw.sudoku;

/*
数独的一个可行解  详细注释
 */
public class Sudoku_ {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0);
    }

    // 相当于暴力穷举数独上的每一个点，就是遍历二维数组，每次选择1~9
    // 结束条件当找到了， 或者是遍历出了然后进入最后一个节点的时候 return
    boolean found = false; // 这个来判断是否找到了

    private void backtrack(char[][] board, int index) {
        if (found) return; // 每次进来这个节点如果是找到了直接返回。。

        int m = 9;
        int n = 9;
        if (index == m * n) {
            found = true;// 全局设置为true，后面遍历遇到直接返回
            return;
        }
        int row = index / m;
        int col = index % n;
        if (board[row][col] != '.') {
            backtrack(board, index + 1);
            return; // 不应该往下走选择的逻辑
        }
        for (char c = '1'; c <= '9'; c++) {
            if (!isValid(board, c, row, col)) continue;
            board[row][col] = c;
            backtrack(board, index + 1);
            if (found) return; // 回溯后面的代码刚要离开这个回溯点的时候，离开回溯点，如果找到了，那么直接返回，不需要撤销
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, char c, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;
            if (board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == c)
                return false; // 这里索引 列是每次012 循环想到%3, 行是每次间隔3个+1想到 / 3 012/3 0  345/3 1
        }
        return true;
    }
}
