package com.wjw;

import java.util.LinkedList;
import java.util.List;

/*
全排列问题
 */
public class Lc46 {
    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> permute(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        // 路径中的元素会别标记为true，避免重复使用
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used);
        return res;
    }

    // 路径： 记录在track中
    // 选择列表： nums中不存在track的那些元素
    // 结束条件：nums中的元素都在track中出现
    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                // nums[i]已经存在track中，跳过
                continue;
            }
            // 做选择
            track.add(nums[i]);
            backtrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }

    }
}
