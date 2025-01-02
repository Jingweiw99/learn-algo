package com.wjw.array;

import java.util.Arrays;

/*
轮转数组
 */
public class Lc189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] help = new int[n];
        for (int i = 0; i < n; i++) {
            help[i] = nums[i];
        }
//        for (int i = 0, j = k; i < n && j < n + k; i++, j = (j + 1) % n) {
//            System.out.println(i + " " + j);
//            nums[j] = help[i];
//        }
        for (int i = 0; i < n; i++) {
            nums[(i + k) % n] = help[i];
        }
    }

    public static void main(String[] args) {
        Lc189 test = new Lc189();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        test.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

}
