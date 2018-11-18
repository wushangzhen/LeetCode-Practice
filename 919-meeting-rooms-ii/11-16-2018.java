/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Point {
    int time;
    int flag;
    public Point(int time, int flag) {
        this.time = time;
        this.flag = flag;
    }
}
class PointComparator implements Comparator<Point> {
    public int compare(Point a, Point b) {
        if (a.time == b.time) {
            return a.flag - b.flag;
        }
        return a.time - b.time;
    } 
}
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        List<Point> list = new ArrayList<>();
        for (Interval interval : intervals) {
            list.add(new Point(interval.start, 1));
            list.add(new Point(interval.end, -1));
        }
        Collections.sort(list, new PointComparator());
        int count = 0;
        int max = 0;
        for (Point point : list) {
            if (point.flag == 1) {
                count++;
            } else {
                count--;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
