/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode h;
    Random r;
    public Solution(ListNode head) {
        r = new Random();
        h = head;
        
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode c = h;
        ListNode res = h;
        for (int i = 1; c.next != null; i++) {
            c = c.next;
            if (r.nextInt(i + 1) == i) {
                res = c;
            }
        }
        return res.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
