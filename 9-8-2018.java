/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of segment tree.
     * @param index: index.
     * @param value: value
     * @return: nothing
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if (root.start == root.end && root.start == index) {
            root.max = value;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (mid < index && index <= root.end) {
            modify(root.right, index, value);
        } 
        if (mid >= index && root.start <= index) {
            modify(root.left, index, value);
        }
        root.max = Math.max(root.left.max, root.right.max);
    }
}
