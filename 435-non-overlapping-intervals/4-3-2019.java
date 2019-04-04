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
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int n = intervals.length;
        Arrays.sort(intervals, (a, b)->(a.end - b.end));
        int pos = intervals[0].end;
        int ans = 1;
        for (int i = 0; i < intervals.length; i++) {
            if (pos > intervals[i].start) {
                continue;
            }
            ans++;
            pos = intervals[i].end;
        }
        return n - ans;
    }
}
