package com.wjw.binaryTree;

/*
二叉树的直径

可能不经过root根节点
那我们遍历节点，每个节点获取左右的最大长度
 */
public class Lc543 {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    // 定义这个函数返回root的子树的最大链长 子树为空 返回-1 因为一个节点返回0
    private int dfs(TreeNode root) {
        if (root == null) return -1;
        int lLen = dfs(root.left) + 1;
        int rLen = dfs(root.right) + 1;
        maxDiameter = Math.max(maxDiameter, lLen + rLen);
        return Math.max(lLen, rLen);
    }
}
