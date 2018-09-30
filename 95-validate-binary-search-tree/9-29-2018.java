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
 class ResultType {
     boolean isValid;
     int max;
     int min;
     ResultType(boolean isValid, int max, int min) {
         this.isValid = isValid;
         this.max = max;
         this.min = min;
     }
 }

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        ResultType result = helper(root);
        return result.isValid;
    }
    ResultType helper(TreeNode node) {
        if (node == null) {
            return null; //new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ResultType left = helper(node.left);
        ResultType right = helper(node.right);
        if (left == null && right == null) {
            return new ResultType(true, node.val, node.val);
        }
        if (left != null && right == null) {
            if (left.isValid && node.val > left.max) {
                return new ResultType(true, node.val, left.min);
            } else {
                return new ResultType(false, 0, 0);
            }
        }
        if (right != null && left == null) {
            if (right.isValid && node.val < right.min) {
                return new ResultType(true, right.max, node.val);
            } else {
                return new ResultType(false, 0, 0);
            }
        }
        if (left.isValid && right.isValid && left.max < node.val && node.val < right.min) {
            return new ResultType(true, right.max, left.min);
        }
        return new ResultType(false, 0, 0);
    }
}
