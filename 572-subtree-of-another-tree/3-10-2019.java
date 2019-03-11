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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }
    boolean equal(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && equal(s.left, t.left) && equal(s.right, t.right);
    }
    
    boolean traverse(TreeNode s, TreeNode t) {
        if (s == null) {
            if (t == null) {
                return true;
            } else {
                return false;
            }
        }
        return equal(s, t) || traverse(s.left, t) || traverse(s.right, t);
    }
}
