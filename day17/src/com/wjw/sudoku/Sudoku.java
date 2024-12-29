package com.wjw.sudoku;

/*
找出数独的一个解 Lc37
 */
public class Sudoku {
    // 传入一个board，找到一个可行解填充到board既可
    public void solveSudoku(char[][] board) {
        backtrack(board, 0);
        print(board);
    }

    private void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean found = false;
    // 枚举二维数组，这里修改为枚举index， 由 28行解码出对应的行和列
    private void backtrack(char[][] board, int index) {
        if (found) {
            return;
        }
        int m = 9, n = 9;
        int i = index / n, j = index % n;
        if (index == m * n) {
            found = true;
            return;
        }
        if (board[i][j] != '.') {
            backtrack(board, index + 1);
            return;
        }
        for (char c = '1'; c <= '9'; c++) {
            if (!isValid(board, i, j, c))
                continue;
            board[i][j] = c;
            backtrack(board, index + 1);
            if (found) { // 刚要进入和刚要离开的时候都需要加上这个
                return;
            }
            board[i][j] = '.';
        }
    }

    // 判断i j 位置上是否能填c
    private boolean isValid(char[][] board, int i, int j, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c) return false;
            if (board[k][j] == c) return false;
            if (board[(i / 3) * 3 + k / 3][(j / 3) * 3 + k % 3] == c)
                return false; // 0 12345678 / 3 000 111 222  %3 012 012 012
        }
        return true;
    }


    public static void main(String[] args) {
        Sudoku test = new Sudoku();
        char[][] board = new char[][]{new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'}, new char[]{
                '.', '9', '8', '.', '.', '.', '.', '6', '.'}, new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'}, new char[]{
                '4', '.', '.', '8', '.', '3', '.', '.', '1'}, new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'}, new char[]{
                '.', '6', '.', '.', '.', '.', '2', '8', '.'}, new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'}, new char[]{
                '.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        test.solveSudoku(board);
    }
}
