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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depthX = 0;
        int depthY = 0;
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null && temp.right != null) {
                    if ((temp.left.val == x && temp.right.val == y)
                       || (temp.left.val == y && temp.right.val == x)) {
                        return false;
                    }
                }
                if (temp.left != null) {
                    if (temp.left.val == x) {
                        depthX = depth;
                    } else if (temp.left.val == y) {
                        depthY = depth;
                    }
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    if (temp.right.val == x) {
                        depthX = depth;
                    } else if (temp.right.val == y) {
                        depthY = depth;
                    }
                    q.add(temp.right);
                }
            }
        }
        return depthX == depthY;
        
    }
}
