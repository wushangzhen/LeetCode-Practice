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
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    private List<Integer> result = new ArrayList<Integer>();
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        if (root == null || k1 > k2) {
            return result;
        }
        findElement(root, k1, k2);
        return result;
    }
    void findElement(TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.val < k1) {
            findElement(root.right, k1, k2);
        } else if (root.val > k2) {
            findElement(root.left, k1, k2);
        } else {
            result.add(root.val);
            findElement(root.left, k1, k2);
            findElement(root.right, k1, k2);
        }
    }
}
