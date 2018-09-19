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
     * @return: the length of the longest consecutive sequence path
     */
    private int maxLength;
    public int longestConsecutive(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        maxLength = 0;
        helper(root, 1);
        return maxLength;
    }
    void helper(TreeNode root, int curLength) {
        if (curLength > maxLength) {
            maxLength = curLength;
        }
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.left.val - 1 == root.val) {
                helper(root.left, curLength + 1);
            } else {
                helper(root.left, 1);
            }
        } else {
            helper(root.left, curLength);
        }
        if (root.right != null) { 
            if (root.right.val - 1 == root.val) {
                helper(root.right, curLength + 1);
            } else {
                helper(root.right, 1);
            }
        } else {
            helper(root.right, curLength);
        }
    }
}
