package com.wjw;

/*
旋转图像
需要原地修改二维数组
 */
public class Lc48 {
    public void rotate(int[][] matrix) {
        // ij 对调，然后反转内层数组
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 旋转
        for (int[] ints : matrix) {
            reverse(ints);
        }
    }

    private void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
