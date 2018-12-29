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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stk = new Stack<>();
        stk.add(root);
        TreeNode last = null;
        while (!stk.isEmpty()) {
            TreeNode item = stk.peek();
            if (((item.left == last || item.left == null) && item.right == null) || ((item.left == null || last != null) && item.right == last)) {
                res.add(stk.pop().val);
                last = item;
                continue;
            }
            if (item.right != null) {
                stk.push(item.right);
            }
            if (item.left != null) {
                stk.push(item.left);
            }
        }
        return res;
    }
}
