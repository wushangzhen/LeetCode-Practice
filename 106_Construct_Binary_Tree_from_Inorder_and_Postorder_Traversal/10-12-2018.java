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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }
    TreeNode helper(int[] inorder, int[] postorder, int startP, int startI, int endI) {
        if (startI > endI || startP < 0) {
            return null;
        }
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[startP]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[startP]);
        TreeNode left = helper(inorder, postorder, startP - (endI - index) - 1, startI, index - 1);
        TreeNode right = helper(inorder, postorder, startP - 1, index + 1, endI);
        root.left = left;
        root.right = right;
        return root;
    }
}
