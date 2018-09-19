/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
 class SegmentTree {
     int start, end, min;
     SegmentTree left, right;
     SegmentTree(int start, int end, int min) {
         this.start = start;
         this.end = end;
         this.min = min;
         left = null;
         right = null;
     }
 }

public class Solution {
    /**
     * @param A: An integer array
     * @param queries: An query list
     * @return: The result list
     */
    public SegmentTree build(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }
        SegmentTree root = new SegmentTree(start, end, A[start]);
        if (start == end) {
            return root;
        }
        int mid = (start + end) / 2;
        root.left = build(start, mid, A);
        root.right = build(mid + 1, end, A);
        root.min = Math.min(root.left.min, root.right.min);
        return root;
    }
    public int query(SegmentTree root, int start, int end) {
        if (start <= root.start && root.end <= end) {
            return root.min;
        }
        int mid = (root.start + root.end) / 2;
        int leftMin = Integer.MAX_VALUE, rightMin = Integer.MAX_VALUE; // this should not be 0
        if (start <= mid) {
            if (mid < end) {
                leftMin = query(root.left, start, mid);
            } else {
                leftMin = query(root.left, start, end);
            }
        }
        if (mid < end) {
            if (start <= mid) {
                rightMin = query(root.right, mid + 1, end);
            } else {
                rightMin = query(root.right, start, end);
            }
        }
        return Math.min(leftMin, rightMin);
    }
    public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        SegmentTree root = build(0, A.length - 1, A);
        for (Interval in : queries) {
            result.add(query(root, in.start, in.end));
        }
        return result;
    }
}
