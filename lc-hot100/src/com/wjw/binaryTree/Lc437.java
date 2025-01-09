package com.wjw.binaryTree;

/*
路径总和3

 */
public class Lc437 {
    //    public int pathSum(TreeNode root, int targetSum) {
//
//    }
    TreeNode target;

    public TreeNode findNode(TreeNode root, int val) {

        dfs(root, val);
        return target;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) return;
        if (root.val == val) target = root;
        dfs(root.left, val);
        dfs(root.right, val);
    }
}
