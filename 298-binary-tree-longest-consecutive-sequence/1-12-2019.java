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
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return max;
    }
    int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int localMax = 1;
        if (root.right != null) {
            if (root.val + 1 == root.right.val) {
                localMax = Math.max(localMax, right + 1);
            }
        }
        if (root.left != null) {
            if (root.val + 1 == root.left.val) {
                localMax = Math.max(localMax, left + 1);
            }
        }
        max = Math.max(max, localMax);
        return localMax;
    }
}
