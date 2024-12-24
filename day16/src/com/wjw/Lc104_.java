package com.wjw;

/*
求二叉树的最大深度的 分解问题解法 上一个是遍历解法

求一颗二叉树的最大深度， 等于左二叉树最大深度，右二叉树最大深度的最大值+1
 */
public class Lc104_ {
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }
}
