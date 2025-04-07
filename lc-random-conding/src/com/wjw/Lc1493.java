package com.wjw;

/*
给一个二进制数组，删除1个0之后全部为1的最长子数组
如果不存在遮掩的子数组，请你返回0

转换成滑动窗口中只能有一个0
 */
public class Lc1493 {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int zeroCnt = 0;
        int maxLen = 0;
        while (right < nums.length) {
            int c = nums[right++];
            if (c == 0)
                zeroCnt++;
            while (zeroCnt > 1) {
                int c1 = nums[left];
                if (c1 == 0)
                    zeroCnt--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left - 1);
        }
        return maxLen;
    }
}
