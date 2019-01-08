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
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        List<Integer> res = new ArrayList<>();
        while (!stk.isEmpty() || cur != null) {
            while (cur != null) {
                stk.push(cur);
                if (cur.left != null) {
                    cur = cur.left;
                } else if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur = null;
                }
            }
            cur = stk.pop();
            res.add(cur.val);
            if (!stk.isEmpty() && stk.peek().left == cur) {
                cur = stk.peek().right;
            } else {
                cur = null;
            }
        }
        return res;
    }
}
