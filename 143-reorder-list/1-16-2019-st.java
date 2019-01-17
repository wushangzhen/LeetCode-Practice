/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode last = null;
        while (p2 != null && p2.next != null) {
            last = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        while (p1.next != null) {
            ListNode temp = last.next;
            last.next = p1.next;
            p1.next = p1.next.next;
            last.next.next = temp;
        }
        p1 = head;
        p2 = last.next;
        ListNode tail = head;
        last.next = null;
        while (p1 != null) {
            ListNode next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p1.next.next;
            tail = p2;
            p2 = next;
        }
        if (p2 != null) {
            tail.next = p2;
        }
    }
}
