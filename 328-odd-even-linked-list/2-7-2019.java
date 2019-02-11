/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 0->1->2->3->4->5->NULL
    // 0->1->
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode last = null;
        ListNode pos = dummy;
        int count = 1;
        while (cur != null) {
            if (count % 2 == 1) {
                if (last == null) {
                    pos = pos.next;
                    last = cur;
                    cur = cur.next;
                } else {
                    ListNode temp = cur.next;
                    cur.next = pos.next;
                    pos.next = cur;
                    last.next = temp;
                    pos = pos.next;
                    cur = temp;
                }
            } else {
                last = cur;
                cur = cur.next;
            }
            count++;
        }
        return dummy.next;
    }
}
