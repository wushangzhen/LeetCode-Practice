/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    void dfs(TreeNode root, List<List<Integer>> res, int curLevel) {
        if (root == null) {
            return;
        }
        if (curLevel >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(curLevel).add(root.val);
        dfs(root.left, res, curLevel + 1);
        dfs(root.right, res, curLevel + 1);
    }
}
