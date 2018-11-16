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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null) {
            ListNode cur = pre.next;
            while (cur.next != null && pre.next.val == cur.next.val) {
                cur = cur.next;
            }
            if (cur == pre.next) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
        }
        return dummy.next;
        
    }
}
