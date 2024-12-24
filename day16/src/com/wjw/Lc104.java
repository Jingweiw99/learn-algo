package com.wjw;


/*
找到一颗二叉树的最大深度
 */
public class Lc104 {
    static int depth;
    static int maxDepth;

    public static int maxDepth(TreeNode root) {
        traverse(root);
        return maxDepth;
    }

    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepth(tree));// 3
    }
}
