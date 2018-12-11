/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode tail;
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            tail = head;
            return head;
        }
        ListNode reversed = reverseList(head.next);
        tail.next = head;
        tail = head;
        head.next = null;
        return reversed;
    }
}
