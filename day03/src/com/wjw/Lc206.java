package com.wjw;

/*
反转链表
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Lc206 {


    public static ListNode reverseList1(ListNode head) {
        ListNode reverseHead = null;
        ListNode currentNode = head;
        ListNode tempNode = null;

        while (currentNode != null) {
            tempNode = currentNode.next;
            currentNode.next = reverseHead;
            reverseHead = currentNode;
            currentNode = tempNode;
        }
        return reverseHead;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode last = null;
        // 上面的方法是将变量实现提取出来
        while (head != null) {
            ListNode headNext = head.next;
            head.next = last;
            last = head;
            head = headNext;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode nodes = new ListNode(1, new ListNode(2, new ListNode(3, null)));
//        ListNode listNode = reverseList1(nodes);
        ListNode listNode = reverseList(nodes);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
