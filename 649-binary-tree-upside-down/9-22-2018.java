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
     * @param root: the root of binary tree
     * @return: new root
     */
    TreeNode dfs(TreeNode cur) {
        if (cur.left == null) {
            return cur;
        }    
        TreeNode newNode = dfs(cur.left);
        cur.left.left = cur.right;
        cur.left.right = cur;
        cur.left = null;
        cur.right = null;
        return newNode;
    }   
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        return dfs(root);
    }
}
