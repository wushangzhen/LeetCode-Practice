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
        if (root == null) {
            return 0;
        }
        TreeNode lowerNode = lowerBound(root, target);
        TreeNode upperNode = upperBound(root, target);
        if (lowerNode == null) {
            return upperNode.val;
        }
        if (upperNode == null) {
            return lowerNode.val;
        }
        if (target - lowerNode.val > upperNode.val - target) {
            return upperNode.val;
        } else {
            return lowerNode.val;
        }
    }
    TreeNode lowerBound(TreeNode node, double target) {
        if (node == null) {
            return null;
        }
        if (node.val >= target) {
            return lowerBound(node.left, target);
        }
        TreeNode lowerNode = lowerBound(node.right, target);
        if (lowerNode != null) {
            return lowerNode;
        }
        return node;
    }
    TreeNode upperBound(TreeNode node, double target) {
        if (node == null) {
            return null;
        }
        if (node.val < target) {
            return upperBound(node.right, target);
        }
        TreeNode upperNode = upperBound(node.left, target);
        if (upperNode != null) {
            return upperNode;
        }
        return node;
    }
}
