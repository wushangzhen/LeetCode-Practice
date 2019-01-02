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
    ListNode current;
    public int getLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int size = getLength(head);
        current = head;
        return helper(size);
    }
    TreeNode helper(int size) {
        if (size == 0) {
            return null;
        }
        TreeNode left = helper(size / 2);
        TreeNode root = new TreeNode(current.val);
        System.out.println(current.val);
        current = current.next;
        TreeNode right = helper(size - 1 - size / 2);
        root.left = left;
        root.right = right;
        return root;
    }
}
