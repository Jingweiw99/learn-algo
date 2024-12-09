package com.wjw;

import java.util.LinkedList;
import java.util.Queue;

public class Test2 {
    // 基本的二叉树节点
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int i) {
            this.val = i;
        }
    }

    // 二叉树的层序遍历框架  需要深度理解二叉树的遍历过程，和每个节点进入进出的关系。
    // 前中后序节点都要每个位置的代码都需要了解清楚！！！
    static void levelOrderTraverse(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
             // 当前层节点个数
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 访问当前节点
                System.out.println("depth = " + depth + ", val = " + cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        levelOrderTraverse(root);
    }
}
