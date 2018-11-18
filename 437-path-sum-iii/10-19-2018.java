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
        helper(root, map, sum, 0);
        return count; 
    }
    public void helper(TreeNode root, Map<Integer, Integer> map, int sum, int curSum) {
        if (root == null) {
            return;
        }
        curSum += root.val;
        if (map.containsKey(curSum - sum)) {
            count += map.get(curSum - sum);
        }
        if (!map.containsKey(curSum)) {
            map.put(curSum, 1);
        } else {
            map.put(curSum, map.get(curSum) + 1);
        }
        helper(root.left, map, sum, curSum);
        helper(root.right, map, sum, curSum);
        map.put(curSum, map.get(curSum) - 1);
    } 
}
