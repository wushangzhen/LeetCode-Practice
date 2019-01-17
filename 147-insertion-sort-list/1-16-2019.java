/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode p = head.next;
        head.next = null;
        ListNode last = dummy;
        ListNode pos = dummy;
        while (p != null) {
            last = dummy;
            pos = dummy;
            while (pos != null && pos.val <= p.val) {
                last = pos;
                pos = pos.next;
            }
            ListNode temp = last.next;
            last.next = p;
            p = p.next;
            last.next.next = temp;
        }
        return dummy.next;
    }
}
