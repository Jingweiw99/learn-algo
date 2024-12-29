package com.wjw;

import java.util.ArrayList;
import java.util.List;

/*
不含重复数字的全排列
 */
public class Lc46 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        traverse(nums, track, used);
        return res;
    }

    private void traverse(int[] nums, List<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            System.out.println(track);
            res.add(new ArrayList<>(track)); // 是全局的track，需要保存当时的track
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            track.add(nums[i]);
            used[i] = true;
            traverse(nums, track, used);
            track.remove(track.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Lc46 test = new Lc46();
        List<List<Integer>> permute = test.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
