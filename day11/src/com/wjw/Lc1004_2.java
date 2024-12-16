package com.wjw;

/*
最长的1
第二种想法: 也是滑动窗口这样代码比较简洁，都是使用的滑动窗口
 */
public class Lc1004_2 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int windowOneCount = 0;
        int res = 0; // 这里记录结果长度
        while (right < nums.length) {
            if (nums[right] == 1) {
                windowOneCount++;
            }
            right++;
            // 当里面的0的长度大于k的时候缩小， 其实缩出来之后就是等于k了直接更新结果
            while (right - left - windowOneCount > k) {
                if (nums[left] == 1) {
                    windowOneCount--;
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
