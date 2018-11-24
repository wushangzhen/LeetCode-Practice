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
        Map<TreeNode, Integer> map = new HashMap<>();
        helper(root, 0, map);
        int num = max - min + 1;
        for (int i = 0; i < num; i++) {
            res.add(new ArrayList<>());
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            int index = map.get(temp);
            res.get(index - min).add(temp.val);
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        return res;
    }
    void helper(TreeNode root, int index, Map<TreeNode, Integer> map) {
        if (root == null) {
            return;
        }
        min = Math.min(index, min);
        max = Math.max(index, max);
        map.put(root, index);
        helper(root.left, index - 1, map);
        helper(root.right, index + 1, map);
    }
}
