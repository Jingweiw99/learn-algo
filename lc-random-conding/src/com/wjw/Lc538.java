package com.wjw;

/*
将二叉搜索树转换为累加树
 */
public class Lc538 {
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }


}
