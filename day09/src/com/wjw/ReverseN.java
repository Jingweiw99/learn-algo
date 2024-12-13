package com.wjw;

/*
反转链表的前n个节点

 */
public class ReverseN {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode newHead = reverseN(head, 2);
        System.out.println(newHead);
    }

    private static ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        // 反转前n个节点  反转一个节点相当于返回当前head
        // 先翻转钱n个节点，找到下一个节点 将原来的头head.next指向这个
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
        // 出来如果cur为空说明已经翻转成功了 下面这一行其实可以省略， head.next本身指向空了，再next指向空也可以
        if (cur == null) return pre;
        head.next = cur;
        return pre;
    }
}
