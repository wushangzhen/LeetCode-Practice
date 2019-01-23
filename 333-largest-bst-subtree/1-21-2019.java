/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ResultType {
    boolean isBST;
    int size;
    int max;
    int min;
    public ResultType(boolean isBST, int size, int max, int min) {
        this.isBST = isBST;
        this.size = size;
        this.max = max;
        this.min = min;
    }
}
class Solution {
    int size = 1;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return size;
    }
    ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            size = Math.max(size, left.size + right.size + 1);
            return new ResultType(true, left.size + right.size + 1, Math.max(root.val, right.max), Math.min(root.val, left.min));
        }
        return new ResultType(false, left.size + right.size + 1, Math.max(root.val, right.max), Math.min(root.val, left.min));
    }
}
