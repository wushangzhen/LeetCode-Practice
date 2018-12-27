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
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root); 
        TreeNode last = null;
        while (!stk.isEmpty()) {
            TreeNode temp = stk.peek();
            if ((last != null && last == temp.right) || (temp.left == null && temp.right == null)
             || (last != null && last == temp.left && temp.right == null)) {
                last = temp;
                res.add(stk.pop().val);
                continue;
            }
            if (temp.right != null) {
                stk.push(temp.right);
            }
            if (temp.left != null) {
                stk.push(temp.left);
            }
        }
        return res;
    }
}
