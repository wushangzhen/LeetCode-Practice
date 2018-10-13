/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ResultType {
    boolean isB;
    int depth;
    public ResultType(boolean isB, int depth) {
        this.isB = isB;
        this.depth = depth;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isB;
    }
    ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (!left.isB || !right.isB) {
            return new ResultType(false, 0);
        }
        if (Math.abs(left.depth - right.depth) > 1) {
            return new ResultType(false, 0);
        }
        return new ResultType(true, Math.max(left.depth, right.depth) + 1);
    }
}
