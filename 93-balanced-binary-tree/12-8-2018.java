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
    int depth;
    boolean isB;
    public ResultType(int depth, boolean isB) {
        this.depth = depth;
        this.isB = isB;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        ResultType res = helper(root);
        return res.isB;
    }
    ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, true);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (!left.isB || !right.isB || Math.abs(left.depth - right.depth) > 1) {
            return new ResultType(0, false);
        }
        return new ResultType(Math.max(left.depth, right.depth) + 1, true);
    }
}
