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
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stk = new Stack<>();
        if (root == null) {
            return ans;
        }
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode cur = stk.pop();
            ans.add(0, cur.val);
            if (cur.left != null) {
                stk.push(cur.left);
            }
            if (cur.right != null) {
                stk.push(cur.right);
            }
        }
        return ans;
    }
}
