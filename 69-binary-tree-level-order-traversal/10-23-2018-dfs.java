/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        int maxHeight = 0;
        int height = 0;
        while (true) {
            ArrayList<Integer> level = new ArrayList<>();
            dfs(root, level, maxHeight, height);
            if (level.size() == 0) {
                break;
            }
            res.add(level);
            maxHeight++;
        }
        return res;
    }
    void dfs(TreeNode root, List<Integer> level, int maxHeight, int height) {
        if (root == null || height > maxHeight) {
            return;
        }
        if (height == maxHeight) {
            level.add(root.val);
            return;
        }
        dfs(root.left, level, maxHeight, height + 1);
        dfs(root.right, level, maxHeight, height + 1);
    }
}
