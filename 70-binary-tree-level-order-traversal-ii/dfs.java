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
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, 0, result);
        return result;
    }
    void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (level >= result.size()) {
            result.add(0, new ArrayList<>());
        }
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
        result.get(result.size() - level - 1).add(node.val);
    }
}
