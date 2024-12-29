package com.wjw;

import java.util.ArrayList;
import java.util.List;

/*
组合总和
给一个不重复元素的数组，找出所有的等于目标值的列表，返回全部的列表

 */
public class Lc39 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        for (int i = start; i < candidates.length; i++) { // 关键是这里怎么减枝
            track.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, track);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lc39 test = new Lc39();
        List<List<Integer>> list = test.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(list);
    }
}
