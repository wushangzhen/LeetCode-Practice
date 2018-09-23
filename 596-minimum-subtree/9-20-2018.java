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
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    private int min = Integer.MAX_VALUE;
    TreeNode result = new TreeNode(0);
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        int temp = findSum(root);
        if (temp < min) {
            return root;
        } else {
            return result;
        }
    }
    int findSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = findSum(node.left);
        int right = findSum(node.right);
        int sum = left + right + node.val;
        if (sum < min) {
            min = sum;
            result = node;
        }
        return sum;
    }
}
