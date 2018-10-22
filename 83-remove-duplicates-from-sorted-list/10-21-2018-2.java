/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = head;
        dummy.next = head;
        ListNode p = head;
        while (p != null) {
            if (p.val != tail.val) {
                tail.next = p;
                tail = p;
            }
            p = p.next;
        }
        tail.next = null;
        return dummy.next;
    }
}
