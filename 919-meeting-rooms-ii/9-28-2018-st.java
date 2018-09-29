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
 class Point {
     int time;
     int flag;
     Point(int time, int flag) {
         this.time = time;
         this.flag = flag;
     }
     public static Comparator<Point> PointComparator = new Comparator<Point>() {
         public int compare(Point p1, Point p2) {
             if (p1.time == p2.time) {
                 return p1.flag - p2.flag;
             } else {
                 return p1.time - p2.time;
             }
         }
     };
 }

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        List<Point> list = new ArrayList<>(intervals.size() * 2);
        for (Interval i : intervals) {
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }
        Collections.sort(list, Point.PointComparator);
        int count = 0, ans = 0;
        for (Point p : list) {
            if (p.flag == 1) {
                count++;
            } else {
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
