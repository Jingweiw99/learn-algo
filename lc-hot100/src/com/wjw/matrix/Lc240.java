package com.wjw.matrix;

/*
搜索二维矩阵2
这题可以直接暴力
或者每一行二分查找

或者z字形查找
 */
public class Lc240 {
    // z查找 从左下角开始找
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
