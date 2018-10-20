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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) {
                    return a.end - b.end;
                }
                return a.start - b.start;
            }
        });
        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (i == 0) {
                result.add(intervals.get(i));
                continue;
            }
            if (i != 0) {
                Interval now = intervals.get(i);
                Interval last = result.get(result.size() - 1);
                if (now.start > last.end) {
                    result.add(now);
                    continue;
                }
                if (now.end > last.end) {
                    result.get(result.size() - 1).end = now.end;
                }
            }
        }
        return result;
    }
}
