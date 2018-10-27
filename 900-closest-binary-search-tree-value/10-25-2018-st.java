/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        TreeNode lower = findLower(root, target);
        TreeNode upper = findUpper(root, target);
        if (lower == null && upper != null) {
            return upper.val;
        }
        if (lower != null && upper == null) {
            return lower.val;
        }
        return target - lower.val > upper.val - target ? upper.val : lower.val;
    }
    TreeNode findLower(TreeNode root, double target) {
        if (root == null) {
            return null;
        }
        if (root.val >= target) {
            return findLower(root.left, target);
        }
        TreeNode lowerNode = findLower(root.right, target);
        if (lowerNode != null) {
            return lowerNode;
        }
        return root;
    }
    TreeNode findUpper(TreeNode root, double target) {
        if (root == null) {
            return null;
        }
        if (root.val < target) {
            return findUpper(root.right, target);
        }
        TreeNode upperNode = findUpper(root.left, target);
        if (upperNode != null) {
            return upperNode;
        }
        return root;
    }
    
}
