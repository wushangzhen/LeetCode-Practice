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
     boolean isBalance;
     int level;
     ResultType (boolean isBalance, int level) {
         this.isBalance = isBalance;
         this.level = level;
     }
 }

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        ResultType result = helper(root);
        return result.isBalance;
    }
    ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (left.isBalance && right.isBalance && Math.abs(left.level - right.level) <= 1) {
            return new ResultType(true, Math.max(left.level, right.level) + 1);
        } else {
            return new ResultType(false, Math.max(left.level, right.level) + 1);
        }
    }
}
