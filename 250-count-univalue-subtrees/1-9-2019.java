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
    int num;
    long unique;
    public ResultType(int num, long unique) {
        this.num = num;
        this.unique = unique;
    }
}
class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root).num;
    }
    ResultType helper(TreeNode node) {
        if (node == null) {
            return new ResultType(0, Long.MAX_VALUE);
        }
        ResultType leftRes = helper(node.left);
        ResultType rightRes = helper(node.right);
        if (leftRes.unique == rightRes.unique) {
            if ((node.left == null && node.right == null) || node.val == leftRes.unique) {
                return new ResultType(leftRes.num + rightRes.num + 1, node.val);
            }
        } else if (node.left == null || node.right == null) {
            if (node.left != null && node.val == leftRes.unique) {
                return new ResultType(leftRes.num + rightRes.num + 1, node.val);
            }
            if (node.right != null && node.val == rightRes.unique) {
                return new ResultType(leftRes.num + rightRes.num + 1, node.val);
            }
        }
        return new ResultType(leftRes.num + rightRes.num, Long.MAX_VALUE);
    } 
}
