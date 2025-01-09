package com.wjw.binaryTree;

/*
对称二叉树
对称二叉树的左节点， 右节点 需要有 left的值等于right的值 left.left.val == right.right.val
这是一个递归过程
 */
public class Lc101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return traverse(root.left, root.right);
    }

    private boolean traverse(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            if (left == null && right == null) return true;
            return false;
        }
        if (left.val != right.val) return false;
        return traverse(left.left, right.right) && traverse(left.right, right.left);
    }
}
