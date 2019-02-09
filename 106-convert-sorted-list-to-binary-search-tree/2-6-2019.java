/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode last = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            last = slow;
            slow = slow.next;
        }
        // [-10,-3,0,5,9]
        // [-10, -3, 0, 5]
        TreeNode root = new TreeNode(slow.val);
        if (fast == slow) {
            return root;
        }
        last.next = null;
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(slow.next);
        root.left = left;
        root.right = right;
        return root;
    }
}
