/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (p1 != null || p2 != null) {
            int v1 = p1 == null ? Integer.MAX_VALUE : p1.val;
            int v2 = p2 == null ? Integer.MAX_VALUE : p2.val;
            if (v1 < v2) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
                p.next = null;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
                p.next = null;
            }
        }
        return dummy.next;
    }
}
