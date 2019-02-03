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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stk = new Stack<>();
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
        while (!stk.isEmpty()) {
            TreeNode tmp = stk.pop();
            res.add(tmp.val);
            TreeNode rightNode = tmp.right;
            while (rightNode != null) {
                stk.push(rightNode);
                rightNode = rightNode.left;
            }
        }
        return res;
    }
}
