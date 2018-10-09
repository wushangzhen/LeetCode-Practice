/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
}
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) {
            return result;
        }
        Queue<Interval> pq = new PriorityQueue<>(new IntervalComparator());
        for (Interval i : intervals) {
            pq.add(i);
        }
        while (!pq.isEmpty()) {
            Interval i = pq.poll();
            if (result.isEmpty()) {
                result.add(i);
                continue;
            }
            Interval prev = result.get(result.size() - 1);
            if (prev.end < i.start) {
                result.add(i);
                continue;
            }
            if (prev.end >= i.end) {
                continue;
            } else if (prev.end < i.end) {
                prev.end = i.end;
            }   
        }
        return result;
        
    }
}
