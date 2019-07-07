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
    List<TreeNode> res;
    Set<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        helper(root, true);
        return res;
    }
    TreeNode helper(TreeNode root, boolean isRoot) {
        if (root == null) {
            return null;
        }
        boolean delete = set.contains(root.val);
        if (isRoot && !delete) {
            res.add(root);
        }
        root.left = helper(root.left, delete);
        root.right = helper(root.right, delete);
        return delete ? null : root;
    }
}
