/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        int cnt1 = 1;
        while (p1.next != null) {
            p1 = p1.next;
            cnt1++;
        }
        int cnt2 = 1;
        while (p2.next != null) {
            p2 = p2.next;
            cnt2++;
        }
        if (p1 != p2) {
            return null;
        }
        p1 = headA;
        p2 = headB;
        if (cnt1 > cnt2) {
            for (int i = 0; i < cnt1 - cnt2; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < cnt2 - cnt1; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
