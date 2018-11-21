/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        int count = 0;
        while (cur != null) {
            count++;
            if (count % k == 0) {
                prev = swapOnePair(prev, cur.next);
                cur = prev.next;
            } else {
                cur = cur.next;
            }
            
        }
        return dummy.next;
    }
    ListNode swapOnePair(ListNode prev, ListNode post) {
        ListNode start = prev.next;
        ListNode cur = start.next;
        while (start.next != post) {
            ListNode temp = prev.next;
            prev.next = cur;
            start.next = cur.next;
            cur.next = temp;
            cur = start.next;
        }
        return start;
    }
}
