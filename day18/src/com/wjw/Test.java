package com.wjw;

/*
回溯和dfs区别
我的总结就是：
dfs关注每个节点上的值，最后收集起来。
回溯就是关注每一次的选择，也就是枝。
本质上二者都是穷举所有可能，然后减枝。

这里测试dfs经典题目 岛屿问题
 */
public class Test {
    // 二维矩阵的dfs遍历
    void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (visited[i][j]) {
            return; // 遍历过了(i,j)
        }
        // 进入当前节点
        visited[i][j] = true;
        System.out.println(grid[i][j]);
        // 抽象成四叉树
        // 上 下 左 右
        dfs(grid, i - 1, j, visited);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i, j + 1, visited);
    }

    public static void main(String[] args) {
        Test test = new Test();
        boolean[][] visited = new boolean[3][3];
        test.dfs(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}}, 0, 0, visited);
        // 每次遍历到了 一个数，往里面走，然后每次都会碰到边界，或者visited。这样遍历了所有的点。
        // 然后归，都走17行的 走过了的逻辑。
        // 本质上是一副图
    }
}
