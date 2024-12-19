package com.wjw;

import java.util.ArrayList;
import java.util.List;

/*
螺旋矩阵
 */
public class Lc54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 给上下左右边界 上一边走完top-1，其他一样
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        while (res.size() < m * n) {
            // 上边界小于等于下边界的时候，从左到右 left ~ right
            if (top <= bottom) {
                int left1 = left;
                while (left1 <= right) {
                    res.add(matrix[top][left1]);
                    left1++;
                }
                top++;
            }
            // 从上到下
            if (right >= left) {
                int top1 = top;
                while (top1 <= bottom) {
                    res.add(matrix[top1][right]);
                    top1++;
                }
                right--;
            }
            // 从右到左
            if (bottom >= top) {
                int right1 = right;
                while (right1 >= left) {
                    res.add(matrix[bottom][right1]);
                    right1--;
                }
                bottom--;
            }
            // 从下到上
            if (left <= right) {
                int bottom1 = bottom;
                while (bottom1 >= top) {
                    res.add(matrix[bottom1][left]);
                    bottom1--;
                }
                left++;
            }
        }
        return res;
    }
}
