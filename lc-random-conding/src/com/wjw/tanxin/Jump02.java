package com.wjw.tanxin;

/*
跳跃游戏1
这一题 就尽量的往后跳既可。
具有贪心选择性质，局部的最优解可以直接推导出全局的最优解。

 */
public class Jump02 {
    // 传入一个nums数组， 判断从下标0开始，能够跳到最后一个位置
    /*
      当前索引下标为i,最远可以跳到i + nums[i]
      判断这个数是否>= n -1
      是：返回true
      否：i + nums[i] x 最为下标 x + nums[x]

      // 这个还剩下20多个测试用例没通过
      正确的贪心算法看Jump03
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int longestJump = 0 + nums[0];
        if (longestJump >= n - 1) {
            return true;
        }
        // 当最远距离小于n-1
        while (longestJump < n - 1) {
            longestJump = longestJump + nums[longestJump];
            if (longestJump >= n - 1) {
                return true;
            }
            // 走到0 发现longestJump < n-1 && nums[longestJump] == 0
            if(longestJump < n-1 && nums[longestJump] == 0) return false;
        }
        return false;
    }


    public static void main(String[] args) {
        Jump02 test = new Jump02();
        System.out.println(test.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(test.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
