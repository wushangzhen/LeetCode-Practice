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
    public void recoverTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode cur = root;
        TreeNode first = null;
        TreeNode second = null;
        
        while (cur != null) {
            if (cur.left == null) {
                if (prev != null && prev.val > cur.val) {
                    if (first == null) {
                        first = prev;
                        second = cur;
                    } else {
                        second = cur;
                    }
                }
                prev = cur;
                cur = cur.right;
            } else {
                TreeNode temp = cur.left;
                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = cur;
                    cur = cur.left;
                }
                if (temp.right == cur) {
                    if (prev != null && prev.val > cur.val) {
                        if (first == null) {
                            first = prev;
                            second = cur;
                        } else {
                            second = cur;
                     }
                }
                    prev = cur;
                    temp.right = null;
                    cur = cur.right;
                }
            } 
        }
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
