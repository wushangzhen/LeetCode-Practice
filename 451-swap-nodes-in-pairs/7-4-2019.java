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
        int k = 2;
        return swapKPairs(head, 2);
    }
    public ListNode swapKPairs(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;
        while (p != null) {
            int count = 0;
            while (p != null && count != k - 1) {
                p = p.next;
                count++;
            }
            if (p == null) {
                break;
            }
            if (count == k - 1) {
                ListNode temp = pre.next;
                helper(pre, p);
                pre = temp;
                p = pre.next;
            }
        }
        return dummy.next;
    }
    public void helper(ListNode pre, ListNode tail) {
        ListNode head = pre.next;
        ListNode post = tail.next;
        while (head.next != post) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = pre.next;
            pre.next = temp;
        }
    }
}
