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
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stk = new Stack<>();
        TreeNode temp = root;
        while (temp != null) {
            stk.push(temp);
            temp = temp.left;
        }
        TreeNode newNode = new TreeNode(0);
        TreeNode last = newNode;
        while (!stk.isEmpty()) {
            TreeNode t = stk.pop();
            last.right = t;
            last = last.right;
            temp = t.right;
            while (temp != null) {
                stk.push(temp);
                temp = temp.left;
            }
            t.left = null;
            t.right = null; // important
        }
        return newNode.right;
    }
}
