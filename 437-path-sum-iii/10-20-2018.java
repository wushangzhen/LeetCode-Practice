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
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(0, root, map, sum);
        return count;
    }
    void helper(int curSum, TreeNode root, Map<Integer, Integer> map, int sum) {
        if (root == null) {
            return;
        }
        curSum += root.val;
        if (map.containsKey(curSum - sum)) {
            count += map.get(curSum - sum);
        }
        map.putIfAbsent(curSum, 0);
        map.put(curSum, map.get(curSum) + 1);
        helper(curSum, root.left, map, sum);
        helper(curSum, root.right, map, sum);
        map.put(curSum, map.get(curSum) - 1);
    }
}
