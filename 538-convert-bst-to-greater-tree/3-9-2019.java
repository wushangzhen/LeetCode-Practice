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
    TreeNode lastNode;
    public TreeNode convertBST(TreeNode root) {
        lastNode = new TreeNode(0);
        helper(root);
        return root;
    }
    void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.right);
        root.val = root.val + lastNode.val;
        lastNode = root;
        helper(root.left);
    }
}
