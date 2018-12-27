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
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        } 
        Stack<TreeNode> stk = new Stack<>();
        stk.add(root);
        while (!stk.isEmpty()) {
            TreeNode temp = stk.pop();
            res.add(temp.val);
            if (temp.right != null) {
                stk.add(temp.right);
            }
            if (temp.left != null) {
                stk.add(temp.left);
            }
        }
        return res;
    }
}
