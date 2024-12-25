package com.wjw;


import java.util.LinkedList;
import java.util.Queue;

/*
路径总和
 */
public class Lc112 {
    class Node {
        TreeNode node;
        int val;

        public Node(TreeNode node, int val) {
            this.node = node;
            this.val = val;
        }
    }

    // 每个节点都持有权重  也可以同时给一个queue记录当前的val
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(root, root.val));
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                if (cur.node.left == null && cur.node.right == null) {
                    if (cur.val == targetSum) {
                        return true;
                    }
                    continue;
                }
                if (cur.node.left != null) {
                    q.offer(new Node(cur.node.left, cur.val + cur.node.left.val));
                }
                if (cur.node.right != null) {
                    q.offer(new Node(cur.node.right, cur.val + cur.node.right.val));
                }
            }
        }
        return false;
    }


}
