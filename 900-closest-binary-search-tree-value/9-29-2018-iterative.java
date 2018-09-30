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
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode prev = null;
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.val > target) {
                if (prev != null) {
                    if (target - prev.val < node.val - target) {
                        return prev.val;
                    } else {
                        return node.val;
                    }
                } else {
                    return node.val;
                }
            }
            if (node.right != null) {
                TreeNode temp = node.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
            prev = node;
        }
        return prev.val;
    }
}
