package com.wjw;

/*
连接每一个节点的下一个指针2
 */
public class Lc116_ {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    // 使用三叉解法
    public Node connect(Node root) {
        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node left, Node right) {
        if (left == null || right == null) return;
        traverse(left.left, left.right);
        traverse(left.right, right.left);
        traverse(right.left, right.right);
        left.next = right;
    }

    public static void main(String[] args) {
        Lc116_ test = new Lc116_();
        Node connectNode = test.connect(new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, new Node(6), new Node(7), null), null));
        System.out.println(connectNode);

//        Node cnd = test.connect(new Node());
//        System.out.println(cnd);

    }
}
