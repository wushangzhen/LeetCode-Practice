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
        List<String> results = new ArrayList<String>();
        if (root == null) {
            return results;
        }
        String str = "";
        traverse(root, results, 0, str);
        return results;
    }
    void traverse(TreeNode root, List<String> results, int index, String str) {
        if (root == null) {
            return;
        }
        if (str == "") {
            str = str + String.valueOf(root.val);
        } else {
            str = str + "->";
            str = str + String.valueOf(root.val);
        }
        if (root.left == null && root.right == null) {
            results.add(str);
        }
        traverse(root.left, results, str.length() - 1, str);
        traverse(root.right, results, str.length() - 1, str);
        str = str.substring(0, str.length() - index);
        
    }
}
