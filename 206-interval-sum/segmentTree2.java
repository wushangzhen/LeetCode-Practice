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
    int start, end;
    Long sum;
    SegmentTree left, right;
    SegmentTree(int start, int end, Long sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        left = null;
        right = null;
    } 
}
public class Solution {
    /**
     * @param A: An integer list
     * @param queries: An query list
     * @return: The result list
     */
    public SegmentTree buildHelper(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }
        SegmentTree root = new SegmentTree(start, end, Long.valueOf(A[start]));
        if (start == end) {
            return root;
        }
        int mid = (start + end) / 2;
        root.left = buildHelper(start, mid, A);
        root.right = buildHelper(mid + 1, end, A);
        root.sum = root.left.sum + root.right.sum; 
        return root;
    }
    public Long query(SegmentTree root, int start, int end) {
        if (start <= root.start && end >= root.end) {
            return root.sum;
        }
        int mid = (root.start + root.end) / 2;
        Long leftSum = 0L, rightSum = 0L;
        if (start <= mid) {
            if (mid < end) {
                leftSum = query(root.left, start, mid);
            } else {
                leftSum = query(root.left, start, end);
            }
        }
        if (mid < end) {
            if (mid > start) {
                rightSum = query(root.right, mid + 1, end);
            } else {
                rightSum = query(root.right, start, end);
            }
        }
        return leftSum + rightSum;
    }
    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        // write your code here
        List<Long> result = new ArrayList<Long>();
        SegmentTree root = buildHelper(0, A.length - 1, A);
        for (Interval elem : queries) {
            result.add(query(root, elem.start, elem.end));
        }
        return result;
    }
}
