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
        if (head == null || head.next == null) {
            return head;
        } 
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next != null) {
            ListNode temp = dummy.next;
            dummy.next = head.next;
            head.next = head.next.next;
            dummy.next.next = temp;
        }
        return dummy.next;
    }
}
