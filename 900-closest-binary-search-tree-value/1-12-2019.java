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
    public int closestValue(TreeNode root, double target) {
        TreeNode lower = findLower(root, target);
        TreeNode upper = findUpper(root, target);
        if (lower == null) {
            return upper.val;
        }
        if (upper == null) {
            return lower.val;
        }
        return upper.val - target < target - lower.val ? upper.val : lower.val;
        
    }
    TreeNode findLower(TreeNode root, double target) {
        if (root == null) {
            return root;
        }
        if (root.val > target) {
            return findLower(root.left, target);
        }
        TreeNode rightRes = findLower(root.right, target);
        return rightRes == null ? root : rightRes;
    }
    TreeNode findUpper(TreeNode root, double target) {
        if (root == null) {
            return root;
        }
        if (root.val < target) {
            return findUpper(root.right, target);
        }
        TreeNode leftRes = findUpper(root.left, target);
        return leftRes == null ? root : leftRes;
    }
}
