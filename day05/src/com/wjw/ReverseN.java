package com.wjw;

/*
反转前n个节点，并返回新头
 */
public class ReverseN {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode node) {
            this.val = val;
            this.next = node;
        }
    }

    public static ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null, cur = head, nxt = head.next;
        while (n > 0) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
            n--;
        }
        head.next = cur;
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        print(head);
        head = reverseN(head, 2);
        print(head);
    }

    private static void print(ListNode head) {
        String str = "";
        while(head !=null) {
            str += head.val + "->";
            head=head.next;
        }
        System.out.println(str);
    }
}
