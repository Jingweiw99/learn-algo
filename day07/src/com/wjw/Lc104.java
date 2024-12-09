package com.wjw;

/*
找到二叉树的最小深度

 */

import java.util.LinkedList;
import java.util.Queue;

public class Lc104 {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int i) {
            this.val = i;
        }
    }

    static int minDepth(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                System.out.println(cur.val);
                if (cur.left == null && cur.right == null) return depth;
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
        return -1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);
        System.out.println(minDepth(root));
    }
}
