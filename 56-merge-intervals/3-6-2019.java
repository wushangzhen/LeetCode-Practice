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
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) {
                    return a.end - b.end;
                }
                return a.start - b.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        for (Interval interval : intervals) {
            if (res.isEmpty()) {
                res.add(interval);
            } else {
                Interval last = res.get(res.size() - 1);
                if (last.end >= interval.start) {
                    if (last.end < interval.end) {
                        last.end = interval.end;
                    }
                } else {
                    res.add(interval);
                }
                
            }
        }
        return res;
    }
}
