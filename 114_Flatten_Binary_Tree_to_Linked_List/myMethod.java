/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Stack<TreeNode> stk = new Stack<TreeNode> ();
    TreeNode tail = new TreeNode(-1);
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        pushAll(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            if (node.right != null) {
                pushAll(node.right);
                node.right = null;
            }
        }
        while (root != null) {
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }
    void pushAll(TreeNode root) {
        for (; root != null; root = root.left) {
            stk.push(root);
            tail.left = root;
            tail = root;
        }
    }
}
