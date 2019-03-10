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
    int max = -1;
    TreeNode res;
    public int findBottomLeftValue(TreeNode root) {
        res = new TreeNode(0);
        helper(root, 0);
        return res.val;
    }
    void helper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > max) {
            max = depth;
            res = root;
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }
}
