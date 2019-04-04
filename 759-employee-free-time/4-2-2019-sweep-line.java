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
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        int OPEN = 0, CLOSE = 1;
        List<int[]> events = new ArrayList<>();
        for (List<Interval> employee: schedule) {
            for (Interval iv : employee) {
                events.add(new int[]{iv.start, OPEN});
                events.add(new int[]{iv.end, CLOSE});
            }
        }
        Collections.sort(events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<Interval> ans = new ArrayList<>();
        int prev = -1;
        int bal = 0;
        for (int[] event : events) {
            if (bal == 0 && prev >= 0) {
                ans.add(new Interval(prev, event[0]));
            }
            bal += event[1] == OPEN ? 1 : -1;
            prev = event[0];
        }
        return ans;
    }
}
