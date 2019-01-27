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
     double sum;
     double num;
     public ResultType(double sum, double num) {
         this.sum = sum;
         this.num = num;
     }
 }

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    double max = Integer.MIN_VALUE;
    TreeNode res;
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        res = null;
        if (root == null) {
            return res;
        }
        helper(root);
        return res;
    }
    ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType leftRes = helper(root.left);
        ResultType rightRes = helper(root.right);
        double sum = leftRes.sum + rightRes.sum + root.val;
        double num = leftRes.num + rightRes.num + 1;
        double average = sum / num;
        if (max < average) {
            max = average;
            res = root;
        }
        return new ResultType(sum, num);
    }
}
