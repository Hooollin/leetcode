/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (34.96%)
 * Likes:    1192
 * Dislikes: 88
 * Total Accepted:    195.1K
 * Total Submissions: 557.8K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < m - 1; i++) {
            prev = curr;
            curr = curr.next;
            n -= 1;
        }
        ListNode p = prev;
        ListNode t = curr;
        for (int i = 0; i < n; i++) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        if (p == null) {
            head = prev;
        } else {
            p.next = prev;
        }
        t.next = curr;
        return head;
    }
}
