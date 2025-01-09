package com.wjw.binaryTree;

import java.util.ArrayList;
import java.util.List;

/*
二叉树的中序遍历
 */
public class Lc94 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }
}
