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
    public int findSecondMinimumValue(TreeNode root) {
        int res = -1;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.val < smallest) {
                secondSmallest = smallest;
                smallest = temp.val;
            } else if (temp.val != smallest) {
                secondSmallest = Math.min(secondSmallest, temp.val);
            }
            if (temp.left != null) {
                q.add(temp.left);
                q.add(temp.right);
            }
        }
        return secondSmallest == Integer.MAX_VALUE ? -1 : secondSmallest;
    }
}
