package com.wjw.ListNode;

public class ListNodeTest {
    // 输入一个数组，转换为一个单链表
    public ListNode transToNode(int[] nums) {
        // 如果数组为空或者长度小于1返回空
        // 如果不是遍历数组，每次都添加到链表上
        ListNode dummy = new ListNode(-1), p = dummy;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            p.next = node;
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNodeTest test = new ListNodeTest();
        ListNode node = test.transToNode(nums);
        System.out.println(node);
    }
}
