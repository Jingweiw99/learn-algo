package com.wjw.plzh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
组合总和2
给一个candidate 和 target
candidate有重复数字，找出等于target的所有可能，其中candidate中的每个数字只能选择一次

输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
 */
public class Lc40 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> track = new ArrayList<>();
        backtrack(candidates, target, 0, track);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> track) {
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            track.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, track);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lc40 test = new Lc40();
        List<List<Integer>> lists = test.combinationSum2(new int[]{1, 1, 2, 5, 6, 7, 10}, 8);
        System.out.println(lists);
    }
}
