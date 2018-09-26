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
        if (root == null) {
            return -1;
        }
        Stack<TreeNode> stk = new Stack<>();
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
        TreeNode prev = new TreeNode(Integer.MAX_VALUE);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            if (node.val > target) {
                if (node.val - target > target - prev.val) {
                    return prev.val;
                } else {
                    return node.val;
                }
            }
            prev = node;
            if (node.right != null) {
                stk.push(node.right);
                node = node.right;
                while (node.left != null) {
                    stk.push(node.left);
                    node = node.left;
                }
            }
        }
        return prev.val;
    }
}
