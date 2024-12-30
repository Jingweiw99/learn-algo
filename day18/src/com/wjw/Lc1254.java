package com.wjw;

/*
封闭岛屿的数量
关键是想出靠岸的都淹没掉
这题目1是海水，0是陆地
 */
public class Lc1254 {
    public int closedIsland(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
//        // i 1 ~ m-2 j 1 ~ n-2 不能这样直接设置，只能通过一部分测试用例
//        for (int i = 1; i < m - 1; i++) {
//            for (int j = 1; j < n - 1; j++) {
//                if (grid[i][j] == 0) {
//                    res++;
//                    dfs(grid, i, j);
//                }
//            }
//        }
        // 需要的是上下左右边界都淹没掉，不是设置为1
        for (int col = 0; col < n; col++) {
            dfs(grid, 0, col);
            dfs(grid, m - 1, col);
        }
        for (int row = 0; row < m; row++) {
            dfs(grid, row, 0);
            dfs(grid, row, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if (grid[i][j] == 1) return;
        grid[i][j] = 1;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] intArray = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        Lc1254 test = new Lc1254();
        System.out.println(test.closedIsland(intArray)); // 2
    }
}
