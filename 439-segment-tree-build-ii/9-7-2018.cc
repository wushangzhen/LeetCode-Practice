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
     * @param A: a list of integer
     * @return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        return buildHelper(0, A.length - 1, A);
    }
    SegmentTreeNode buildHelper(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, A[start]);
        if (start == end) {
            return root;
        }
        int mid = (start + end) / 2;
        root.left = buildHelper(start, mid, A);
        root.right = buildHelper(mid + 1, end, A);
        root.max = Math.max(root.left.max, root.right.max);
        return root;
    }
}
