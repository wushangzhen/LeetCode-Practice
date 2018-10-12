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
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        helper(root, path, result, target);
        return result;
    }
    void helper(TreeNode root, List<Integer> path, 
        List<List<Integer>> result, int target) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                if (target - root.val == 0) {
                    path.add(root.val);
                    result.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                    return;
                }
            }
            path.add(root.val);
            helper(root.left, path, result, target - root.val);
            helper(root.right, path, result, target - root.val);
            path.remove(path.size() - 1);
    }
};
