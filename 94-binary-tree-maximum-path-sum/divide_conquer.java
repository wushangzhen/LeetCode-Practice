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
     * @param root: The root of binary tree.
     * @return: An integer
     */
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        helper(root);
        return maxSum;
   }
   public int helper(TreeNode root) {
       if (root == null) {
           return 0;
       }
       if (root.val > maxSum) {
           maxSum = root.val;
       }
       int left = helper(root.left);
       int right = helper(root.right);
       int sum1 = left + root.val;
       int sum2 = right + root.val;
       int sum3 = left + right + root.val;
       int sum =  Math.max(sum1, sum2);
       sum = Math.max(sum, sum3);
       if (sum > maxSum) {
           maxSum = sum;
       }
       return Math.max(sum1, sum2);
   }
}
