/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                head = head.next;
                p1 = p1.next;
                p1.next = null;
            } else {
                p2.next = head;
                head = head.next;
                p2 = p2.next;
                p2.next = null;
            }
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
