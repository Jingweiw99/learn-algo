package com.wjw.matrix;

import java.util.ArrayList;
import java.util.List;

/*
螺旋矩阵
给一个二维数组，顺时针收集全部元素
思路：
1. 定义上下左右边界 top bottom left right
以下2345做死循环，一定会走出
2. 从左边界到右边界， 然后top++ 判断top是否大于 bottom，true就结束。 否则继续
3. 从top到bottom， 然后right-- 判断right是否小于left，true就结束。 否则继续
4. 从right到left， 然后bottom-- 判断bottom是否小于top，true就结束。否则继续
5. 从bottom到top， 然后left++ 判断left是否大于right，true结束，否则继续

 */
public class Lc54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc54 test = new Lc54();
        System.out.println(test.spiralOrder(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}}));
    }
}
