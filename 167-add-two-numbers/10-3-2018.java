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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            ListNode now = new ListNode(0);
            tail.next = now;
            tail = now;
            int sum = l1.val + l2.val + carry;
            if (sum >= 10) {
                carry = sum / 10;
            } else {
                carry = 0;
            }
            now.val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l2 != null) {
            tail.next = l2;
            int sum = l2.val + carry;
            if (sum >= 10) {
                carry = sum / 10;
            } else {
                carry = 0;
            }
            l2.val = sum % 10;
            tail = l2;
            l2 = l2.next;
        }
        while (l1 != null) {
            tail.next = l1;
            int sum = l1.val + carry;
            if (sum >= 10) {
                carry = sum / 10;
            } else {
                carry = 0;
            }
            l1.val = sum % 10;
            tail = l1;
            l1 = l1.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(1);
            tail = tail.next;
        }
        return dummy.next;
    }
}
