/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (k > 0) {
            ListNode tail = dummy;
            while (tail.next != null && tail.next.next != null) {
                tail = tail.next;
            }
            ListNode node = tail.next;
            tail.next = null;
            node.next = dummy.next;
            dummy.next = node;
            k--;
        } 
        return dummy.next;
    }
}
