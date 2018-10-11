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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root);
    }
    int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftResult = helper(root.left);
        int rightResult = helper(root.right);
        if (leftResult == 0) {
            return rightResult + 1;
        }
        if (rightResult == 0) {
            return leftResult + 1;
        }
        return Math.min(leftResult, rightResult) + 1;
    }
}
