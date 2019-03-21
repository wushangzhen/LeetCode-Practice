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
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int n = preorder.length;
        return helper(preorder, 0, n - 1);
    }
    TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int i = 0;
        for (i = start + 1; i <= end; i++) {
            if (preorder[i] > root.val) {
                break;
            }
        }
        root.left = helper(preorder, start + 1, i - 1);
        root.right = helper(preorder, i, end);
        return root;
    }
}
