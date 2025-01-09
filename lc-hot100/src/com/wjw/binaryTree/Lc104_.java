package com.wjw.binaryTree;


import java.util.LinkedList;
import java.util.Queue;

/*
二叉树的最大深度
bfs的思路 层序遍历 实际上执行效率不如上面
 */
public class Lc104_ {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        Lc104_ test = new Lc104_();
        System.out.println(test.maxDepth(root)); // 3
    }
}
