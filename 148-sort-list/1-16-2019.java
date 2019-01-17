/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode last = head;
        while (fast != null && fast.next != null) {
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        last.next = null;
        return merge(sortList(head), sortList(slow));
    }
    ListNode merge(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        if (p1 != null) {
            tail.next = p1; 
        }
        if (p2 != null) {
            tail.next = p2;
        }
        return dummy.next;
    }
}
