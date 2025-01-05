package com.wjw.matrix;

/*
旋转图像
给一个二维矩阵，原地向右旋转90°
 */
public class Lc48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // 每一行reverse
        for (int[] ints : matrix) {
            reverse(ints);
        }
    }

    private void reverse(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Lc48 test = new Lc48();
        test.rotate(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}});
    }
}
