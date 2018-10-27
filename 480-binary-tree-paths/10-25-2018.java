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
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> result = new ArrayList<>();
        traverse(root, "", result);
        return result;
    }
    void traverse(TreeNode root, String str, List<String> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            str += root.val;
            result.add(str);
            return;
        }
        traverse(root.left, str + root.val + "->", result);
        traverse(root.right, str + root.val + "->", result);
    }
}
