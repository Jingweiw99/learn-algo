package com.wjw;

public class Lc79Test {
    public static void main(String[] args) {
        Lc79Test test = new Lc79Test();
        char[] board1 = new char[]{'A', 'B'};
        char[] board2 = new char[]{'C', 'D'};
        char[][] board = new char[][]{board1, board2};
        test.exist(board, "ABD");
    }

    boolean exist;
    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        StringBuilder track = new StringBuilder();
        this.board = board;
        this.word = word;
        // 还可以走多少步 下m-1 右n-1 坐标点xy 00
        int n = board[0].length;
        int m = board.length;
        backtrack(m -1, n -1, 0, 0, track);
        return exist;
    }

    void backtrack(int down, int right, int x, int y, StringBuilder track) {
        if (down < 0 || right < 0 || x >= board.length || y >= board.length) return;
        if (word.length() == track.length()) {
            if (word.equals(track.toString())) {
                exist = true;
            }
            return;
        }
        track.append(board[x][y]);
        backtrack(down - 1, right, x + 1, y, track);
//        track.deleteCharAt(track.length() - 1);
        down++;

        track.append(board[x][y + 1]);
        backtrack(down, right - 1, x, y + 1, track);
        track.deleteCharAt(track.length() - 1);
        right++;
    }
}
