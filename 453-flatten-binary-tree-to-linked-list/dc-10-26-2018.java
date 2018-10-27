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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    TreeNode tail = null;
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        helper(root);
    }
    
    TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if (left != null) {
            tail = left;
            while (tail.right != null) {
                tail = tail.right;
            }
            tail.right = right;
            root.right = left;
            root.left = null;
        }
        return root;
    }
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    TreeNode tail = null;
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        helper(root);
    }
    
    TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if (left != null) {
            tail = left;
            while (tail.right != null) {
                tail = tail.right;
            }
            tail.right = right;
            root.right = left;
            root.left = null;
        }
        return root;
    }
}}
