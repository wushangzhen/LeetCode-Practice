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
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, root.val);
        return res;
        
    }
    int helper(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        res = Math.max(res, left + right);
        if (val == root.val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
