/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode evenHead = new ListNode(0), oddHead = new ListNode(0);
        ListNode p1 = evenHead, p2 = oddHead;
        int count = 0;
        while (head != null) {
            if (count % 2 == 0) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            count += 1;
            head = head.next;
        }
        p2.next = null;
        while (oddHead.next != null) {
            oddHead = oddHead.next;
            p1.next = oddHead;
            p1 = p1.next;
        }
        return evenHead.next;
    }

    public ListNode _oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode op = oddHead, ep = evenHead;
        while (ep != null && ep.next != null) {
            op.next = ep.next;
            op = op.next;
            ep.next = op.next;
            ep = ep.next;
        }
        op.next = evenHead;
        return oddHead;
    }

}
