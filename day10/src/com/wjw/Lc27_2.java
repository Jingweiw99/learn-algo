package com.wjw;

import java.util.Arrays;

/*
第二种想法： 使用快慢指针
原地删除等于val的值，前k个不等于val，返回k的值

大致想法： 什么时候往里面放   放通过k指针放， 找通过快指针i

这种方法会好一点
 */
public class Lc27_2 {
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            nums[k++] = nums[i];
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int k = removeElement(arr, 2);
        System.out.println(k); // 5
        System.out.println(Arrays.toString(arr)); // 0 1 3 0 4 0 4 2
    }

}
