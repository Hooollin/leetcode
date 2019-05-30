/**
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

// link: https://leetcode.com/problems/partition-list/

class Solution {
    // one pass 创建两个链表头，一个用来连接比x大的节点，一个
    // 用来连接比x小的节点，遍历链表，加到对应链表后面，最后合并
    // 两个链表。
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode biggerHead = new ListNode(0);
        ListNode p1 = lessHead, p2 = biggerHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                p1.next = curr;
                p1 = p1.next;
            } else {
                p2.next = curr;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        // 这里p2不一定是head链表结尾，
        // 一定要指向null，不然会导致循环链表
        p2.next = null;
        while (biggerHead.next != null) {
            biggerHead = biggerHead.next;
            p1.next = biggerHead;
            p1 = p1.next;
        }
        return lessHead.next;
    }

}
