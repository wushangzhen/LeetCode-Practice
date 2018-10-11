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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        q1.add(root);
        q2.add(0);
        int max = -1;
        while (!q1.isEmpty()) {
            TreeNode node = q1.remove();
            int depth = q2.remove();
            if (node != null) {
                max = Math.max(max, depth);
                map.put(depth, node.val);
                q1.add(node.left);
                q2.add(depth + 1);
                q1.add(node.right);
                q2.add(depth + 1);
            }   
        }
        for (int i = 0; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
