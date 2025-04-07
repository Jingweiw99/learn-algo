package com.wjw;

import java.util.LinkedList;
import java.util.Queue;

/*
范围二叉树的最小深度
 可以使用递归遍历 或者是 层序遍历 使用层序遍历 这个不需要遍历全部节点
 */
public class Lc111 {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}