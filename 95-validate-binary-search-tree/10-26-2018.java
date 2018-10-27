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
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        return root.val > max && root.val < min && helper(root.left, root.val, max)
            && helper(root.right, min, root.val);
    }
}
