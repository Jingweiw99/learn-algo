package com.wjw;

import java.util.Arrays;

/*
颜色分类 0 1 2
注意这题需要原地修改

java函数是值传递，如果内部新建一个变量得到最后结果，然后将 值赋值给nums，那么外部的nums其实不指向这个新的结果
 */
public class Lc75 {
    public static void sortColors(int[] nums) {
        // 定义 i k p
        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(nums, i, k);
                k++;
            }
        }
        int p = k;
        while (k < n) {
            if (nums[k] == 1) {
                swap(nums, k, p);
                p++;
            }
            k++;
        }
    }

    // 交换nums上i j的值
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 2, 1, 0};
//        int[] nums = {2, 1, 2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
