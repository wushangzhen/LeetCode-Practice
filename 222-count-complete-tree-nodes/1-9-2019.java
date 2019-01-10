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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = 0;
        TreeNode ptr = root;
        while (ptr != null) {
            lh++;
            ptr = ptr.left;
        }
        ptr = root;
        int rh = 0;
        while (ptr != null) {
            rh++;
            ptr = ptr.right;
        }
        if (rh == lh) {
            return (int)Math.pow(2, rh) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
