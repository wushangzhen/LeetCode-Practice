/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        ListNode cur = root;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int remain = n % k;
        int perNum = n / k;
        cur = root;
        int count = 0;
        for (int i = 0; i < k; i++) {
            res[count++] = cur;
            ListNode pre = cur;
            for (int j = 0; j < perNum + ((remain > 0) ? 1 : 0); j++) {
                pre = cur;
                cur = cur.next;
            }
            if (pre != null) {
                pre.next = null;
            }
            remain--;
        }
        return res;
    }
}
