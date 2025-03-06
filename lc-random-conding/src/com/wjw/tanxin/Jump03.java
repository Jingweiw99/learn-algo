package com.wjw.tanxin;

/*
跳跃游戏1
这一题 就尽量的往后跳既可。
具有贪心选择性质，局部的最优解可以直接推导出全局的最优解。

 */
public class Jump03 {
    // 传入一个nums数组， 判断从下标0开始，能够跳到最后一个位置
    /*
     Jump03
     贪心策略，每一步跳能够跳到的最远距离，
     正确的贪心算法应该是在每一步遍历时，
     维护当前能到达的最远位置，
     并且在每一步都尝试更新这个最远位置，
     而不是仅仅从当前的最远位置跳跃。

     维护当前能到达的最远位置 ！！！不是每一步最远，然后跳
     */
    public boolean canJump(int[] nums) {
        // 维护一个当前能达到的最远位置maxReach,然后遍历数组并更新当前可达的最远位置
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果更新之后的maxReach就达到不了当前的i return false
            if (maxReach < i) return false;
            // 首先进来直接更新最远位置
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Jump03 test = new Jump03();
        System.out.println(test.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(test.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(test.canJump(new int[]{2, 5, 0, 0}));
    }
}
