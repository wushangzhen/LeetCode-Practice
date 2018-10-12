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
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                cur = cur.right;
                continue;
            }
            prev = cur.left;
            while (prev.right != null && prev.right != cur) {
                prev = prev.right;
            }
            if (prev.right == null) {
                prev.right = cur;
                cur = cur.left;
                continue;
            }
            if (prev.right == cur) {
                prev.right = null;
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
