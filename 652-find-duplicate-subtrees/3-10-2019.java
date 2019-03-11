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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        helper(root, res, map);
        return res;
    }
    String helper(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if (root == null) {
            return "#";
        }
        String s = root.val + "," + helper(root.left, res, map) + helper(root.right, res, map);
        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2) {
            res.add(root);
        }
        return s;
    }
}
