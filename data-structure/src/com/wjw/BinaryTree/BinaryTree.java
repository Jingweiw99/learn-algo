package com.wjw.BinaryTree;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    // 二叉树的递归遍历
    public void traverse(TreeNode node) {
        if (node == null)
            return;
        traverse(node.left);
        traverse(node.right);
    }

    // 二叉树的额层序遍历
    public static void levelOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        int depth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                System.out.println("depth = " + depth + ", val = " + cur.val); // 能够访问到深度和当前的值
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            depth++;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.left.left = new TreeNode(6);// 这个是最大的深度，深度为4 值为6
        levelOrderTraverse(node);
    }
}
