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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(0, nums.length - 1, nums);
    }
    public TreeNode helper(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = helper(start, mid - 1, nums);
        TreeNode right = helper(mid + 1, end, nums);
        root.left = left;
        root.right = right;
        return root;
    }
}
