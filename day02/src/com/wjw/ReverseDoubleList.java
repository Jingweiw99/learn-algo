package com.wjw;

// 反转双向链表，注意是增么画图的
public class ReverseDoubleList {
    public static class DoubleNode {
        public String value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(String data) {
            value = data;
        }
    }

    public static void main(String[] args) {
        DoubleNode head = new DoubleNode("1");
        head.last = null;
        head.next = new DoubleNode("2");
        head.next.last = head;
        head.next.next = new DoubleNode("3");
        head.next.next.last = head.next;
        head.next.next.next = null;
        print(head);
        // 开始双向链表反转
        head = reverseDoubleList(head);
        System.out.print("反转之后的双向链表为：");
        print(head);
    }

    private static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next; // 相比单向链表多了折行
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void print(DoubleNode node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
