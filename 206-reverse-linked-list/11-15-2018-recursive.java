/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        helper(dummy, head);
        return dummy.next;
    }
    void helper(ListNode pre, ListNode start) {
        if (start == null) {
            return;
        }
        ListNode cur = start;
        ListNode prev = pre;
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;
        ListNode temp = pre.next;
        pre.next = cur;
        cur.next = temp;
        helper(pre.next, cur.next);
    }
}
