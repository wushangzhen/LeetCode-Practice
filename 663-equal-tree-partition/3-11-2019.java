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
    Stack<Integer> stk;
    public boolean checkEqualTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        stk = new Stack<>();
        int total = helper(root);
        stk.pop();
        if (total % 2 == 0) {
            for (int i : stk) {
                if (i == total / 2) {
                    return true;
                }
            }
        }
        return false;
    }
    int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        stk.push(helper(root.left) + root.val + helper(root.right));
        return stk.peek();
    }
}
