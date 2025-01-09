package com.wjw.binaryTree;

/*
二叉树展开为链表
位置是前序遍历的顺序
 */
public class Lc114 {
    // 给一个root节点，转换为链表
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        if (root.left == null && root.right == null) return;
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode p = root.right;
        while (p != null && p.right != null) {
            p = p.right;
        }
        if (p != null) {
            p.right = right;
        } else {
            root.right = right;
        }
    }

    // 不臃肿的写法 就是说先保存下来变量 然后操作
    public void flatten_(TreeNode root) {
        if (root == null) return;
        flatten_(root.left);
        flatten_(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = null;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        Lc114 test = new Lc114();
        test.flatten(root);
        System.out.println(root);
    }
}
