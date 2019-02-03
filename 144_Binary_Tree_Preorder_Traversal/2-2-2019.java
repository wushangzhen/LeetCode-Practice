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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stk = new Stack<>();
        while (root != null) {
            res.add(root.val);
            stk.push(root);
            root = root.left;
        }
        while (!stk.isEmpty()) {
            TreeNode tmp = stk.pop();
            TreeNode rightNode = tmp.right;
            while (rightNode != null) {
                res.add(rightNode.val);
                stk.push(rightNode);
                rightNode = rightNode.left;
            }
        }
        return res;
    }
}
