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
    List<Integer> res;
    int i = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        res = new ArrayList<>();
        return dfs(root, voyage) ? res : Arrays.asList(-1);
    }
    private boolean dfs(TreeNode root, int[] voyage) {
        if (root == null) {
            return true;
        }
        if (root.val != voyage[i++]) {
            return false;
        }
        if (root.left != null && root.left.val != voyage[i]) {
            res.add(root.val);
            return dfs(root.right, voyage) && dfs(root.left, voyage);
        }
        return dfs(root.left, voyage) && dfs(root.right, voyage);
    }
}
