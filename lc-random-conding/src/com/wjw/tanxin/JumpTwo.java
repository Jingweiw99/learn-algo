package com.wjw.tanxin;

/*
跳跃游戏2
从数组nums的索引为0 的位置开始，找出跳到最后需要多少步 （已经保证了可以跳到最后一格）
核心思路: 贪心找到每次经过的能跳到的最远距离maxReach，记录跳了多少次

 */
public class JumpTwo {
    public int jump(int[] nums) {
        int maxReach = 0;
        int end = 0; // 当前跳跃的最远位置
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == end) {
                cnt++;
                end = maxReach;
                if(end >= nums.length - 1) break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        JumpTwo test = new JumpTwo();
        System.out.println(test.jump(nums));
    }
}
