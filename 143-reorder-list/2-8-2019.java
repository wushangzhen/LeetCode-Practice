/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p2 = reverse(slow);
        slow.next = null;
        ListNode p1 = head;
        while (p2 != null) {
            ListNode temp = p1.next;
            p1.next = p2;
            ListNode next = p2.next;
            p2.next = temp;
            p1 = temp;
            p2 = next;
        }
    }
    ListNode reverse(ListNode dummy) {
        //ListNode cur = dummy.next;
        ListNode start = dummy.next;
        while (start.next != null) {
            ListNode cur = start.next;
            start.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }
}
