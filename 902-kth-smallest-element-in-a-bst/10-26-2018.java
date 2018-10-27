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
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        if (root == null) {
            return -1;
        }
        int n = number(root.left);
        if (n == k - 1) {
            return root.val;
        } else if (n < k - 1) {
            return kthSmallest(root.right, k - n - 1);
        } else {
            return kthSmallest(root.left, k);
        }
    }
    
    int number(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = number(root.left);
        int right = number(root.right);
        return left + right + 1;
    }
}
