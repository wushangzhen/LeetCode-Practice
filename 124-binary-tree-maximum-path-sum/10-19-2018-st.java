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
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPathDown(root);
        return maxValue;
    }
    int maxPathDown(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxPathDown(root.left), 0);
        int right = Math.max(maxPathDown(root.right), 0);
        maxValue = Math.max(maxValue, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
