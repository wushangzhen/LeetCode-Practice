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
     * @return: collect and remove all leaves
     */
    Map<Integer, List<Integer>> hash = new HashMap<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        int rootDepth = helper(root);
        for (int i = 1; i <= rootDepth; i++) {
            result.add(hash.get(i));
        }
        return result;
    }
    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        int maxDepth = Math.max(left, right) + 1;
        hash.putIfAbsent(maxDepth, new ArrayList<>());
        hash.get(maxDepth).add(node.val);
        return maxDepth;
    }
}
