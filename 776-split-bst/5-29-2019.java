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
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) {
            return res;
        }
        if (root.val > V) {
            res[1] = root;
            TreeNode[] left = splitBST(root.left, V);
            root.left = left[1];
            res[0] = left[0];
        } else {
            res[0] = root;
            TreeNode[] right = splitBST(root.right, V);
            root.right = right[0];
            res[1] = right[1];
        }
        return res;
    }
}
