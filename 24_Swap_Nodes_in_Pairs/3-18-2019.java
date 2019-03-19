/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 1->2->3->4
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int k = 2;
        ListNode dummy = new ListNode(0);
        ListNode left = dummy;
        ListNode cur = head;
        dummy.next = head;
        while (cur != null) {
            int count = k - 1;
            while (count != 0) {
                cur = cur.next;
                if (cur == null) {
                    break;
                }
                count--;
            }
            if (count == 0) {
                left = swap(left, cur);
                cur = left.next;
            }
        }
        return dummy.next;
    }
    public ListNode swap(ListNode dummy, ListNode end) {
        ListNode head = dummy.next;
        ListNode tail = end.next;
        while (head.next != tail) {
            ListNode temp = dummy.next;
            dummy.next = head.next;
            head.next = head.next.next;
            dummy.next.next = temp;
        }
        return head;
    }
}
