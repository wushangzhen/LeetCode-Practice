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
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty()) {
            int size = q1.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q1.poll();
                list.add(node.val);
                if (node.left != null) {
                    q2.add(node.left);
                }
                if (node.right != null) {
                    q2.add(node.right);
                }
            }
            res.add(list);
            Queue<TreeNode> temp = q1;
            q1 = q2;
            q2 = q1;;
        }
        return res;
    }
}
