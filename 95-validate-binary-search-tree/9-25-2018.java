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
 class ResultType {
     boolean isBst;
     int maxValue, minValue;
     ResultType(boolean isBst, int maxValue, int minValue) {
         this.isBst = isBst;
         this.maxValue = maxValue;
         this.minValue = minValue;
     }
 }

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        ResultType result = helper(root);
        return result.isBst;
    }
    ResultType helper(TreeNode node) {
        if (node == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ResultType left = helper(node.left);
        ResultType right = helper(node.right);
        if (!left.isBst || !right.isBst) {
            return new ResultType(false, 0, 0);
        }
        if (node.left != null && left.maxValue >= node.val 
            || node.right != null && right.minValue <= node.val) {
            return new ResultType(false, 0, 0);
        }
        return new ResultType(true, Math.max(node.val, right.maxValue), Math.min(node.val, left.minValue));
    }
}
