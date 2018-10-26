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
     
    int maxHeight = 0;
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(new ArrayList<>());
        dfs(root, 0, result);
        return result;
    }
    void dfs(TreeNode root, int curLevel, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (curLevel > maxHeight) {
            result.add(new ArrayList<>());
            maxHeight++;
        }
        result.get(curLevel).add(root.val);
        dfs(root.left, curLevel + 1, result);
        dfs(root.right, curLevel + 1, result);
    }
}
