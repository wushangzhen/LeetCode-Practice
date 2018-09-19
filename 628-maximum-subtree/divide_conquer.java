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
     * @return: the maximum weight node
     */
    private int max = Integer.MIN_VALUE;
    TreeNode result = new TreeNode(0);
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        findHelper(root);
        return result;
    }
    int findHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findHelper(root.left);
        int right = findHelper(root.right);
        int temp = root.val + left + right;
        if (temp > max) {
            max = temp;
            result = root;
        }
        return temp;
    }
}
