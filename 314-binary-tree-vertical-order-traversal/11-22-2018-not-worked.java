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
    int min = 0;
    int max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        map.put(0, new ArrayList<>());
        helper(root, 0, map);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
    void helper(TreeNode root, int index, TreeMap<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        if (index < min) {
            map.put(index, new ArrayList<>());
            min = index;
        }
        if (index > max) {
            map.put(index, new ArrayList<>());
            max = index;
        }
        map.get(index).add(root.val);
        helper(root.left, index - 1, map);
        helper(root.right, index + 1, map);
    }
}
