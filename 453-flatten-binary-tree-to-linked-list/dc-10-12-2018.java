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
    TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        helper(root);
    }
    TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        root.right = left;
        root.left = null;
        lastNode = root;
        while (lastNode.right != null) {
            lastNode = lastNode.right;
        }
        lastNode.right = right;
        return root;
    }
}
