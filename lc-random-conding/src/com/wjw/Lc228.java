package com.wjw;

import java.util.ArrayList;
import java.util.List;

/*
汇总有序区间
无重复元素，有序的区间
 */
public class Lc228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1) {
                len++;
                i++;
            }
            res.add(len == 1 ? nums[i] + "" : nums[i - len + 1] + "->" + nums[i]); // 这里无非是用StringBuilder来append优化一下
        }
        return res;
    }

    public static void main(String[] args) {
        Lc228 test = new Lc228();
        System.out.println(test.summaryRanges(new int[]{1, 2, 3, 5, 6, 7, 9})); // ["1->3","5->7","9"]
    }
}
