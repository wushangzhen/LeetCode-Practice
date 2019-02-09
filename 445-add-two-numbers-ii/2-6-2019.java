/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<ListNode> stk1 = new Stack<>();
        Stack<ListNode> stk2 = new Stack<>();
        ListNode dummy = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null) {
            stk1.push(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            stk2.push(p2);
            p2 = p2.next;
        }
        int carry = 0;
        while (!stk1.isEmpty() || !stk2.isEmpty()) {
            int a = stk1.isEmpty() ? 0 : stk1.pop().val;
            int b = stk2.isEmpty() ? 0 : stk2.pop().val;
            int sum = a + b + carry;
            carry = sum / 10;
            int digit = sum % 10;
            ListNode newNode = new ListNode(digit);
            ListNode temp = dummy.next;
            dummy.next = newNode;
            newNode.next = temp;
        }
        if (carry == 1) {
            ListNode newNode = new ListNode(carry);
            ListNode temp = dummy.next;
            dummy.next = newNode;
            newNode.next = temp;
        }
        return dummy.next;
    }
}
