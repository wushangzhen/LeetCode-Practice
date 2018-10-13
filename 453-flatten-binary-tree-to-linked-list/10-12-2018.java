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
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        prev = root;
        flatten(root.left);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        prev.right = right;
        flatten(right);
    }
}
