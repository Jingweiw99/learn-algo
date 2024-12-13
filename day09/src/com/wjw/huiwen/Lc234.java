package com.wjw.huiwen;

/*
判断一个单链表是不是一个回文链表

最容易想到的方法就是先翻转链表， 然后对比两个链表是否相等

不翻转链表可以实现吗？
利用二叉树的后序遍历，
 */
public class Lc234 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Lc234 test = new Lc234();
        test.testTraverse(new ListNode(1, new ListNode(2, new ListNode(3, null))));

        System.out.println(test.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1, null)))));
    }

    // 链表递归后序遍历测试
    public void testTraverse(ListNode head) {
        if (head == null) return;
        System.out.println(head.val); // 1->2->3-> 打印的是1,2,3
        testTraverse(head.next);
        System.out.println(head.val); // 1->2->3-> 打印的是3,2,1
    }

    ListNode left;
    ListNode right;
    boolean isPalindrome = true;
    // 实际的判断回文单链表的代码
    public boolean isPalindrome(ListNode head) {
        left = head;
        traverse(head);
        return isPalindrome;
    }

    private void traverse(ListNode right) {
        if(right == null) return;
        traverse(right.next);
        // right.val 如果左指针不等于右返回false
        if(left.val != right.val) {
            isPalindrome = false;
        }
        left = left.next;
    }
}
