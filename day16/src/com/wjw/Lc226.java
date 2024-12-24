package com.wjw;

/*
翻转一颗二叉树
 */
public class Lc226 {
    public TreeNode invertTree(TreeNode root) {
        // 遍历到每个节点然后反转左右
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        traverse(root.left);
        traverse(root.right);
    }
}
