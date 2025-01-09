package com.wjw.binaryTree;

/*
判断二叉搜索树
主要需要想到 二叉搜索树，需要的是节点大于左边的所有节点，小于右边的所有节点

 */
public class Lc98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    // 给root的值 范围 left ~ right 如果有一个为空，不需要比较
    private boolean dfs(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) return true;
        if (left != null && left.val >= root.val) return false;
        if (right != null && right.val <= root.val) return false;
        return dfs(root.left, left, root) &&
                dfs(root.right, root, right);
    }
}
