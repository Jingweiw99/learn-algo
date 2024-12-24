package com.wjw;

import java.util.LinkedList;
import java.util.Queue;

/*
连接每一个节点的下一个指针
 */
public class Lc116 {
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
    // 比较暴力的解法
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                if (cur != null && cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur != null && cur.right != null) {
                    q.offer(cur.right);
                }
                // i == sz - 1 让这个poll出来的指向null， 否则poll出来的节点指向q的头
                if (i == sz - 1) {
                    if (cur != null) {
                        cur.next = null;
                    }
                } else {
                    cur.next = q.peek();
                }
                // System.out.println(cur);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Lc116 test = new Lc116();
//        Node connectNode = test.connect(new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, new Node(6), new Node(7), null), null));
//        System.out.println(connectNode);

        Node cnd = test.connect(new Node());
        System.out.println(cnd);

    }
}
