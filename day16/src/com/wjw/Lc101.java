package com.wjw;

/*
判断是否是对称的二叉树

 */
public class Lc101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return traverse(root.left, root.right);
    }

    private boolean traverse(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        // 二者都要为真
        return traverse(left.left, right.right) &&
                traverse(left.right, right.left);
    }
}
