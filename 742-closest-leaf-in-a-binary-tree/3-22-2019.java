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
    Map<TreeNode, TreeNode> map;
    Queue<TreeNode> q;
    Set<TreeNode> set = new HashSet<>();
    public int findClosestLeaf(TreeNode root, int k) {
        map = new HashMap<>();
        q = new LinkedList<>();
        dfs(root, null, k);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left == null && temp.right == null) {
                return temp.val;
            }
            if (temp.left != null && !set.contains(temp.left)) {
                set.add(temp.left);
                q.add(temp.left);
            }
            if (temp.right != null && !set.contains(temp.right)) {
                set.add(temp.right);
                q.add(temp.right);
            }
            if (map.containsKey(temp) && map.get(temp) != null && !set.contains(map.get(temp))) {
                set.add(map.get(temp));
                q.add(map.get(temp));
            }
        }
        return 0;
        
    }
    void dfs(TreeNode root, TreeNode father, int k) {
        if (root != null) {
            if (root.val == k) {
                q.add(root);
                set.add(root);
            }
            map.put(root, father);
            dfs(root.left, root, k);
            dfs(root.right, root, k);
        }
    }
}
