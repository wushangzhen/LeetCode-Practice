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
        stk.push(root);
        TreeNode last = null;
        while (!stk.isEmpty()) {
            TreeNode tmp = stk.peek();
            if ((last != null && tmp.right == last) || (tmp.left == null && tmp.right == null) || (last != null && tmp.left == last && tmp.right == null)) {
                res.add(stk.pop().val);
                last = tmp;
            } else {
                if (tmp.right != null) {
                    stk.push(tmp.right);
                } 
                if (tmp.left != null) {
                    stk.push(tmp.left);
                }
            }
        }
        return res;
    }
}
