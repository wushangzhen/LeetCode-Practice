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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }
    int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int dec = 1;
        int inc = 1;
        if (root.left != null) {
            int[] lres = helper(root.left);
            if (root.left.val == root.val - 1) {
                dec = lres[1] + 1;
            } else if (root.left.val == root.val + 1) {
                inc = lres[0] + 1;
            }
        }
        if (root.right != null) {
            int[] rres = helper(root.right);
            if (root.right.val == root.val - 1) {
                dec = Math.max(rres[1] + 1, dec);
            } else if (root.right.val == root.val + 1) {
                inc = Math.max(rres[0] + 1, inc);
            }
        }
        max = Math.max(max, inc + dec - 1);
        return new int[]{inc, dec};
    }
}
