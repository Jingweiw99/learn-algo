package com.wjw.tanxin;

/*
跳跃游戏1 的暴力解 (这个解法在leetcode会超时)
判断开始是否大于等于了数组的长度
首先是能跳跃的次数，
枚举这个次数，每次次数判断能够跳到
如果可以跳到： true
不可以跳到：继续循环

如果整体都循环不到，直接返回false，
 */
public class Jump01 {
    // 传入一个nums数组， 判断从下标0开始，能够跳到最后一个位置
    public boolean canJump(int[] nums) {
        return canJump1(0, nums);
    }

    // 从nums的索引start开始，能够跳转到最后一个位置
    private boolean canJump1(int start, int[] nums) {
        int n = nums[start];
        if (start >= nums.length - 1) return true;
        for (int i = 1; i <= n; i++) {
            boolean b = canJump1(start + i, nums);
            if (b) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Jump01 test = new Jump01();
        System.out.println(test.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(test.canJump(new int[]{3, 2, 1, 0, 4}));


//        int[] nums = {1, 2, 3, 4, 5};
//        int[] dest = new int[3];
//        System.arraycopy(nums, 2, dest, 0, 3);
//        System.out.println(Arrays.toString(dest));
    }
}
