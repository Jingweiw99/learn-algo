package com.wjw.backtrack;

/*
单词搜索
 */
public class Lc79 {
    boolean res = false;

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, words, i, j, 0);
            }
        }
        return res;
    }

    private void dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != words[k]) {
            return;
        }
        if (k == words.length - 1) return;
        board[i][j] = '\0';
        dfs(board, words, i + 1, j, k + 1);
        dfs(board, words, i - 1, j, k + 1);
        dfs(board, words, i, j - 1, k + 1);
        dfs(board, words, i, j + 1, k + 1);
        board[i][j] = words[k];
    }
}
