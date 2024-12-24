package com.wjw;

import java.util.ArrayList;
import java.util.List;

/*
二叉树的前序遍历
收集结果
 */
public class Lc144 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public static void main(String[] args) {
        Lc144 test = new Lc144();
    }
}
