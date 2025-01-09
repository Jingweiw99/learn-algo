package com.wjw.binaryTree;

/*
找到二叉树的最近公共祖先
如果去掉 15行理解 这个函数可以理解为找到root 中为p或者q的节点
进来如果等于哪一个，就直接返回了。 如果在根节点找不到，去子树中找 等于p q的节点 如果找到了就返回。

那么一个节点如果能在左子树和右子树分别找到 对应的p q 那么是公共祖先

第二种情况是， 未递归子树， 但是找到了 等于root的值， 那么子数中一定存在等于另一个节点的值的。  这也是公共祖先，返回这个root既可。
画函数的递归数会很简单 理解
 */
public class Lc236 {
    // 如果一个节点能够在他的左和右节点中分别找到p和q，则改节点为LCA节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode root = new TreeNode(3, p, new TreeNode(2, q, new TreeNode(4)));
        Lc236 test = new Lc236();
        TreeNode ca = test.lowestCommonAncestor(root, p, q);
        System.out.println(ca);
    }
}
