package com.wjw;

import java.util.LinkedList;
import java.util.Queue;

/*
二叉树的层序遍历
 */
public class LevelTraverse {
    public void levelTraverse(TreeNode node) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) { // 加上这个for可以计算深度
                TreeNode cur = q.poll();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
    }
}
