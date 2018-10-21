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
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        helper(root, result, path, target);
        return result;
    }
    void helper(TreeNode root, List<List<Integer>> result, List<Integer> path, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            temp.add(0, path.get(i));
            if (sum == target) {
                result.add(new ArrayList<>(temp));
            }
        }
        helper(root.left, result, path, target);
        helper(root.right, result, path, target);
        path.remove(path.size() - 1);
    }
}
