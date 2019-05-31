/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    long prev = Integer.MAX_VALUE + 1;
    long min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDiffInBST(root.left);
        if (prev != Integer.MAX_VALUE + 1) {
            min = Math.min((long)root.val - prev, min);
        }
        prev = (long)root.val;
        minDiffInBST(root.right);
        return (int)min;
    }
}
