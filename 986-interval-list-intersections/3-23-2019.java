/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> list = new ArrayList<>();
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new Interval[0];
        }
        int p1 = 0;
        int p2 = 0;
        while (p1 < A.length && p2 < B.length) {
            int lo = Math.max(A[p1].start, B[p2].start);
            int hi = Math.min(A[p1].end, B[p2].end);
            if (lo <= hi) {
                list.add(new Interval(lo, hi));
            }
            if (A[p1].end < B[p2].end) {
                p1++;
            } else {
                p2++;
            }
        }
        return list.toArray(new Interval[list.size()]);
    }
}
