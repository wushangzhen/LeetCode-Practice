/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int k = 2;
        int i = 0;
        ListNode cur = head;
        ListNode pre = dummy;
        // 1->2->3->4->null
        // 2->1->3->4->null
        while (cur != null) {
            i++;
            if (i % k == 0) {
                pre = swapOnePair(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next; 
    }
    ListNode swapOnePair(ListNode pre, ListNode post) {
        ListNode start = pre.next;
        ListNode cur = start.next;
        while (start.next != post) {
            ListNode temp = pre.next;
            pre.next = cur;
            start.next = cur.next;
            cur.next = temp;
        }
        return start;
    }
}
