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
        dummy.next = head;
        ListNode cur = head;
        ListNode p = head.next;
        cur.next = null;
        while (p != null) {
            if (cur.val != p.val) {
                ListNode temp = p.next;
                p.next = null;
                cur.next = p;
                p = temp;
                cur = cur.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
