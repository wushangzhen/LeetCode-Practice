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
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        double min = Integer.MAX_VALUE;
        if (root == null) {
            return -1;
        }
        Stack<TreeNode> stk = new Stack<>();
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
        TreeNode prev = new TreeNode(0);
        int result = 0;
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            TreeNode temp = node;
            while (temp.left != null) {
                stk.push(temp.left);
                temp = temp.left;
            }
            if (Math.abs(node.val - target) < min) {
                min = Math.abs(node.val - target);
                result = node.val;
            }
            if (node.right != null) {
                stk.push(node.right);
            }
        }
        return result;
    }
}
