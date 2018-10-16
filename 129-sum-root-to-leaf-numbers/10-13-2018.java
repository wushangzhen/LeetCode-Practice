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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        String s = "";
        helper(root, s);
        return sum;
    }
    void helper(TreeNode root, String s) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            s += String.valueOf(root.val);
            int index = 0;
            while (index < s.length() && s.charAt(index) == '0') {
                index++;
            }
            if (index == s.length()) {
                s = s.substring(0, s.length() - 1);
                return;
            }
            String temp = s.substring(index);
            sum += Integer.parseInt(temp);
            s = s.substring(0, s.length() - 1);
            return;
        }
        helper(root.left, s + String.valueOf(root.val));
        helper(root.right, s + String.valueOf(root.val));
    }
}
