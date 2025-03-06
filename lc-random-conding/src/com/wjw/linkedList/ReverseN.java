package com.wjw.linkedList;

import com.wjw.ListNode;

/*
反转前n个链表
思路：找到第n个节点， 下一个节点 从头到这里反转  然后将第一个的next设置为 下一个节点
 */
public class ReverseN {
    public ListNode reverseN(ListNode head, int n) {
        ListNode newHead = findN(head, n);
        ListNode nxt = newHead.next;
        reverse(head, newHead);
        head.next = nxt;
        return newHead;
    }

    // ListNode从 start，end
    private void reverse(ListNode start, ListNode end) {
        ListNode pre = null;
        while (start != end) {
            ListNode nxt = start.next;
            start.next = pre;
            pre = start;
            start = nxt;
        }
    }

    // 找到head的第n个节点， 保证能够访问到
    private ListNode findN(ListNode head, int n) {
        // 需要走n-1步
        while (n > 1 && head != null) {
            head = head.next;
            n--;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ReverseN test = new ReverseN();
        ListNode newNode = test.reverseN(head, 2);
        System.out.println(newNode); //2 -> 1 -> 3 -> 4
    }
}
