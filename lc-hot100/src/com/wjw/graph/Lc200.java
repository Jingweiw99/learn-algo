package com.wjw.graph;

/*
岛屿数量
 */
public class Lc200 {
    int numIslands(char[][] grid) {
        int islandNums = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islandNums++;
                }
            }
        }
        return islandNums;
    }

    // 将i，j左右的临格淹没
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
