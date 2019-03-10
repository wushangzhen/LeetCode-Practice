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
    private int[] modes;
    private int maxCount = 0;
    private int countMax = 0;
    private int count = 0;
    private int curValue = 0;
    private int index = 0;
    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[countMax];
        countMax = 0;
        curValue = 0;
        count = 0;
        inorder(root);
        return modes;
    }
    public void handleValue(int val) {
        if (curValue == val) {
            count++;
        } else {
            curValue = val;
            count = 1;
        }
        if (count > maxCount) {
            maxCount = count;
            countMax = 1;
        } else if (count == maxCount) {
            if (modes != null) {
                modes[countMax] = curValue;
            }
            countMax++;
        }
        
        return;
    }
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }
}
