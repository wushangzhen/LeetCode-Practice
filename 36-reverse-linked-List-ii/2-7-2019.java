/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int k = n - m + 1;
        while (k != 0) {
            fast = fast.next;
            k--;
        }
        while (m != 1) {
            fast = fast.next;
            slow = slow.next;
            m--;
        }
        ListNode end = fast.next;
        ListNode start = slow.next;
        // 1->2->3 3->2->1
        while (start.next != end) {
            ListNode cur = start.next;
            start.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
        }
        return dummy.next;
        
    }
}
