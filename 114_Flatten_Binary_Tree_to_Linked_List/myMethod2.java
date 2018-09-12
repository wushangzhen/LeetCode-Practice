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
        tail = root;
        pushAll(root); 
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            if (node.left != null) {
                pushAll(node.left);
                node.left = null;
            }
        }
    }
    void pushAll(TreeNode root) {
        for (; root != null; root = root.right) {
            stk.push(root);           
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (tail != root) {
                tail.right = root;
            }
            tail = root;
            
        }
    }
}
