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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int n = inorder.length;
        return helper(preorder, inorder, 0, 0, n - 1);
    }
    TreeNode helper(int[] preorder, int[] inorder, int index, int start, int end) {
        if (index < 0 || index >= preorder.length || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        if (start == end) {
            return root;
        }
        int newIndex = -1;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == preorder[index]) {
                newIndex = i;
                break;
            }
        }
        TreeNode left = helper(preorder, inorder, index + 1, start, newIndex - 1);
        TreeNode right = helper(preorder, inorder, index + newIndex - start + 1, newIndex + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
