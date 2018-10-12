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
        return helper(preorder, inorder, 0, 0, preorder.length - 1, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, 
        int startA, int startB, int endA, int endB) {
        if (startA > endA || startB > endB) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[startA]);
        int index = 0;
        for (int i = startB; i <= endB; i++) {
            if (inorder[i] == preorder[startA]) {
                index = i;
            } 
        }
        TreeNode left = helper(preorder, inorder, startA + 1, startB, endA, index - 1);
        TreeNode right = helper(preorder, inorder, startA + index - startB + 1, index + 1, endA, endB);
        root.left = left;
        root.right = right;
        return root;
    }
}
