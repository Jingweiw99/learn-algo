package com.wjw;

/*
二叉树展开为链表
需要原地修改
 */
public class Lc114 {
    TreeNode dummy = new TreeNode(-1);
    TreeNode p = dummy;

    // 不需要原地修改的版本
    public TreeNode flatten1(TreeNode root) {
        traverse(root);
        return dummy.right;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        p.right = new TreeNode(root.val);
        p = p.right;
        traverse(root.left);
        traverse(root.right);
    }

    // 原地修改的版本 拉平root
    // 内部实现是，左子树拉平，右子树拉平，然后拼接
    public void flatten(TreeNode root) {
        if (root == null) return;
        // 根节点 拼接左节点，拼接右节点
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    public static void main(String[] args) {
        Lc114 test = new Lc114();
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
//        test.flatten(root);
//        System.out.println(root); // 依次查看是1 2 4 5 3 6


        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        test.flatten(root2);
    }
}
