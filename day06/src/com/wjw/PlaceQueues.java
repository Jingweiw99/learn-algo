package com.wjw;

import java.util.Arrays;

/*
n皇后问题 一共多少种摆法
采用回溯 + 剪枝
 */
public class PlaceQueues {
    public static void main(String[] args) {

        new PlaceQueues().placeQueues(5);
    }

    int[] cols; // cols[row] 表示row行cols[row] 列已经拜访上了queue  通过这个其实可以还原二维的稀疏数组
    int ways; // 一共多少种摆法

    void placeQueues(int n) {
        if (n < 2) {
            return;
        }
        cols = new int[n];
        place(0);
        System.out.println(n + "皇后一共有" + ways + "种摆法");
    }

    // 摆放第多少行
    void place(int row) {
        if (row == cols.length) {
            show();
            ways++;
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                cols[row] = col;
                place(row + 1);
            }
        }
    }

    /**
     * 相当于剪枝
     */
    boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == col) return false;
            if (Math.abs(col - cols[i]) == (row - i)) {
                return false;
            }
        }
        return true;
    }

    // 打印出n皇后的解法， 如果摆放给1，不摆放0
    void show() {
        int n = cols.length;
        int[][] res = new int[n][n];
        for (int row = 0; row < n; row++) {
            int coll = cols[row];
            res[row][coll] = 1;
        }
        System.out.println(Arrays.toString(cols));
        // 打印二维数组res
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==============================");
    }
}
