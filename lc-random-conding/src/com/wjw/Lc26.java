package com.wjw;

import java.util.Arrays;

/*
lc26 删除有序数组中的重复项
需要原地修改
返回不重复项的数量
 */
public class Lc26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        // i = 0 - n -1 如果不相等k++ 然后修改当前位置的值，
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        // 给一非递减的数组，最后返回不重复的数字个数，并且原地修改nums
        int[] nums = {1, 1, 2, 3, 3, 4, 5};
        Lc26 test = new Lc26();
        System.out.println(test.removeDuplicates(nums)); // 5
        System.out.println(Arrays.toString(nums));
    }
}
