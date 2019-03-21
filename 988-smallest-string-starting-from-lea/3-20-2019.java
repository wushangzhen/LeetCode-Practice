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
    String res = "";
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        dfs(root, new StringBuilder());
        return res;
    }
    void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append((char)('a' + root.val));
        if (root.left == null && root.right == null) {
            sb.reverse();
            String s = sb.toString();
            sb.reverse();
            if (res.equals("")) {
                res = s;
            } else if (res.compareTo(s) > 0) {
                res = s;
            }
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
