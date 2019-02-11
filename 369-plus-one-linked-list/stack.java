/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> stk = new Stack<>();
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode cur = dummy;
        while (head != null) {
            stk.push(head);
            head = head.next;
        }
        ListNode node = stk.pop();
        int sum = node.val + 1;
        carry = sum / 10;
        sum = sum % 10;
        ListNode newNode = new ListNode(sum);
        newNode.next = dummy.next;
        dummy.next = newNode;
        while (!stk.isEmpty()) {
            ListNode temp = stk.pop();
            int s = temp.val + carry;
            carry = s / 10;
            s = s % 10;
            ListNode t = new ListNode(s);
            t.next = dummy.next;
            dummy.next = t;
        }
        if (carry == 1) {
            ListNode t = new ListNode(carry);
            t.next = dummy.next;
            dummy.next = t;
        }
        return dummy.next;
    }
}
