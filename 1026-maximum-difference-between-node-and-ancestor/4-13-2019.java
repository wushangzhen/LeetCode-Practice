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
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return res;
        }
        helper(root, root.val, root.val);
        return res;
    }
    void helper(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }
        res = Math.max(Math.abs(max - root.val), res);
        res = Math.max(Math.abs(min - root.val), res);
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        helper(root.left, max, min);
        helper(root.right, max, min);
    }
}
