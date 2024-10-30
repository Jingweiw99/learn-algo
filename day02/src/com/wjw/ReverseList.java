package com.wjw;

public class ReverseList {
    public static class Node {
        public String value;
        public Node next;

        public Node(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node head = new Node("1");
        head.next = new Node("2");
        head.next.next = new Node("3");
        print(head);
        // 开始反转
        head = reverseList(head);
        print(head);
    }

    // 反转单向链表   画图最后结束状态是pre指向最后一个节点，next和函数内部head指向null
    private static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 打印链表
    public static void print(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
