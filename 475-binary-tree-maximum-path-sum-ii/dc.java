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
     * @param root: the root of binary tree.
     * @return: An integer
     */
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        int sum1 = left + root.val;
        int sum2 = right + root.val;
        int tempSum = Math.max(sum1, sum2);
        maxSum = Math.max(tempSum, root.val);
        return maxSum;
    }
}
