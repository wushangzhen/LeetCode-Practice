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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null || pre.length == 0 || post.length == 0) {
            return null;
        }
        return helper(pre, post, 0, 0, post.length - 1);
    }
    TreeNode helper(int[] pre, int[] post, int index, int start, int end) {
        if (start > end || index >= pre.length) {
            return null;
        }
        if (start == end) {
            return new TreeNode(post[start]);
        }
        TreeNode root = new TreeNode(pre[index]);
        int newIndex = index + 1;
        int val = 0;
        int i = start;
        if (newIndex < pre.length) {
            val = pre[newIndex];
            for (; i <= end - 1; i++) {
                if (post[i] == val) {
                    break;
                }
            }
            TreeNode left = helper(pre, post, newIndex, start, i);
            TreeNode right = helper(pre, post, m + (i - start) + 1, i + 1, end - 1);
            root.left = left;
            root.right = right;
        }
        return root;
    }
}
