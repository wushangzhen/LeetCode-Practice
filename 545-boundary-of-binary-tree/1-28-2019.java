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
    public boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        TreeNode temp = root.left;
        if (!isLeaf(root)) {
            res.add(root.val);
        }
        while (temp != null) {
            if (!isLeaf(temp)) {
                res.add(temp.val);
            }
            if (temp.left != null) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        helper(root, res);
        int n = res.size();
        temp = root.right;
        while (temp != null) {
            if (!isLeaf(temp)) {
                res.add(n, temp.val);
            }
            if (temp.right != null) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return res;
    }
    void helper(TreeNode root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        if (root.left != null) {
            helper(root.left, res);
        }
        if (root.right != null) {
            helper(root.right, res);
        }
    }
}
