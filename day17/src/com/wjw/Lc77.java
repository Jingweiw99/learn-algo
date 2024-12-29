package com.wjw;

import java.util.ArrayList;
import java.util.List;

/*
组合问题
给一个n和k 请你找出 [1,n]的k个数的组合
n = 4 k = 2 六种情况 12 13 14 23 24 34
4 2 每次需要从[1,2,3,4]中选2个  然后选1之后 从[2,3,4]中选1个 结束是[1,2]  发现是一个递归过程只是上界不同，给一个start

画出决策树后面就简单了
 */
public class Lc77 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> track = new ArrayList<>();
        backtrack(n, k, 1, track);
        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> track) {
        if (k == track.size()) { // k == track.size()
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i + 1, track);// 这里是i不是start
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lc77 test = new Lc77();
        List<List<Integer>> list = test.combine(4, 2);
        System.out.println(list);
    }
}
