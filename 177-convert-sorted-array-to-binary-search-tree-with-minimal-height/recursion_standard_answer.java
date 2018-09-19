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
    /*
     * @param A: an integer array
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        } 
        return constructTree(0, A.length - 1, A);
    }
    TreeNode constructTree(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(A[(start + end) / 2]);
        node.left = constructTree(start, (start + end) / 2 - 1, A);
        node.right = constructTree((start + end) / 2 + 1, end, A);
        return node;
    }
}
