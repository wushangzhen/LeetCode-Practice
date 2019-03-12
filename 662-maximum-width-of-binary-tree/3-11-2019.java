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
    int max = 1;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, 0, 0, map);
        return max;
    }
    void helper(TreeNode root, int depth, int pos, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        
        if (!map.containsKey(depth)) {
            map.put(depth, pos);
        } else {
            max = Math.max(pos - map.get(depth) + 1, max);
        }
        helper(root.left, depth + 1, 2 * pos, map);
        helper(root.right, depth + 1, 2 * pos + 1, map);
    }
}
