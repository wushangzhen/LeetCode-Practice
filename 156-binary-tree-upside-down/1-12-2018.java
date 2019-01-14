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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        TreeNode leftRes = upsideDownBinaryTree(root.left);
        l.left = r;
        l.right = root;
        root.left = null;
        root.right = null;
        return leftRes;
    }
}
