package com.wjw;

import java.util.ArrayList;
import java.util.List;

/*
给一nums数组，请你返回出全排列
采取回溯算法
给一个全局的res，一个路径track 一个记录还能使用的

选择列表 路径 结果
 */
public class Lc46 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> track = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new ArrayList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 判断是否使用了，是 continue 否： 添加到track中 对应的used设置为true
            if (used[i]) continue;
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, used);
            track.remove(track.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Lc46 test = new Lc46();
        System.out.println(test.permute(new int[]{1, 2, 3}));
    }
}
