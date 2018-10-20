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
            return b.flag - a.flag;
        }
        return a.time - b.time;
    }
}
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        List<Point> list = new ArrayList<>();
        for (Interval interval : intervals) {
            list.add(new Point(interval.start, 0));
            list.add(new Point(interval.end, 1));
        }
        Collections.sort(list, new PointComparator());
        int count = 0;
        
        for (int i = 0; i < list.size(); i++) {
            Point point = list.get(i);
            if (point.flag == 0) {
                count++;
            } else {
                count--;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
