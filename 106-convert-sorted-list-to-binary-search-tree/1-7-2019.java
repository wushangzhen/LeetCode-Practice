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
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        this.head = head;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return helper(0, size - 1);
    }
    TreeNode helper(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode left = helper(l, mid - 1);
        TreeNode root = new TreeNode(h.val);
        head = head.next;
        root.left = left;
        root.right = helper(mid + 1, r);
        return root;
    }
}
