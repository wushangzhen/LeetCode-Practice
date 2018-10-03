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
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (root == null || k == 0) {
            return result;
        }
        Stack<TreeNode> lower = new Stack<>();
        Stack<TreeNode> upper = new Stack<>();
        lower = getStack(root, target);
        upper.addAll(lower);
        if (lower.peek().val > target) {
            moveLower(lower);
        } else {
            moveUpper(upper);
        }
        for (int i = 0; i < k; i++) {
            if (lower.isEmpty() || (!upper.isEmpty() && target - lower.peek().val > upper.peek().val - target)) {
                result.add(upper.peek().val);
                moveUpper(upper);
            } else {
                result.add(lower.peek().val);
                moveLower(lower);
            }
        }
        return result;
    }
    private Stack<TreeNode> getStack(TreeNode node, double target) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            if (node.val <= target) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return stack;
    }
    private void moveLower(Stack<TreeNode> lower) {
        TreeNode node = lower.peek();
        if (node.left == null) {
            node = lower.pop();
            while (!lower.isEmpty() && lower.peek().left == node) {
                node = lower.pop();
            }
            return;
        }
        node = node.left;
        while (node != null) {
            lower.push(node);
            node = node.right;
        }
    }
    private void moveUpper(Stack<TreeNode> upper) {
        TreeNode node = upper.peek();
        if (node.right == null) {
            node = upper.pop();
            while (!upper.isEmpty() && upper.peek().right == node) {
                node = upper.pop();
            }
            return;
        }
        node = node.right;
        while (node != null) {
            upper.push(node);
            node = node.left;
        }
    }
}
