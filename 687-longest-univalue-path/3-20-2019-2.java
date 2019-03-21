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
    int res = 1;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return res - 1;
        
    }
    int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int max = 1;
        if (root.left != null && root.val == root.left.val
           && root.right != null && root.val == root.right.val) {
            res = Math.max(res, left + right + 1);
            return Math.max(left, right) + 1;
        }
        if (root.left != null && root.val == root.left.val) {
            max = Math.max(left + 1, max);
        } 
        if (root.right != null && root.val == root.right.val) {
            max = Math.max(right + 1, max);
        }
        res = Math.max(res, max);
        return max;
    }
}
