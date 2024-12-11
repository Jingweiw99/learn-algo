package com.wjw.linked;

/*
找到链表的中间姐点， 如果是偶数找到后面一个。。
我这里的方式是想快节点一定会到达，最后一个节点或者倒数前一个节点。
那么这个时候其实是找到中间靠前的那个节点。
如果不是最后一个节点说明可以往下走。
 */
public class Lc876 {
    public ListNode middleNode(ListNode head) {
        // 两个指针一个一次走两步，一个一次走一步
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            slow = slow.next;
        }
        return slow;
    }
}
