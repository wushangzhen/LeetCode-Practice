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
    TreeNode prev;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        prev = root; // record every end node
        flatten(root.left);
        TreeNode right = root.right;
        root.right = root.left;
        prev.right = right;
        root.left = null;
        flatten(right);
    }
}
