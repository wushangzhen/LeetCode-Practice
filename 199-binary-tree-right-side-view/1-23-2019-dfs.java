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
    int max = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> memo = new HashMap<>();
        if (root == null) {
            return res;
        }
        helper(root, 0, memo);
        for (int i = 0; i <= max; i++) {
            res.add(memo.get(i));
        }
        return res;
    }
    void helper(TreeNode root, int depth, Map<Integer, Integer> memo) {
        if (root == null) {
            return;
        }
        max = Math.max(depth, max);
        if (!memo.containsKey(depth)) {
            memo.put(depth, root.val);
        }
        helper(root.right, depth + 1, memo);
        helper(root.left, depth + 1, memo);
        return;
    }
}
