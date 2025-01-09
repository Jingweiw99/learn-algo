package com.wjw.binaryTree;

/*
二叉树的最大深度
dfs的思路
 */
public class Lc104 {
    int depth = 0;
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return maxDepth;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        depth++;
        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        Lc104 test = new Lc104();
        System.out.println(test.maxDepth(root)); // 3
    }
}
