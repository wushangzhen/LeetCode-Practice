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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    TreeNode tail = null;
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        tail = root;
        flatten(root.left);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        tail.right = right;
        flatten(right);
    }
}
