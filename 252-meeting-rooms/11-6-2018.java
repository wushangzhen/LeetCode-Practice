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
     int flag; // 1 will be start -1 will be end;
     Point(int time, int flag) {
         this.time = time;
         this.flag = flag;
     }
 }
 
 class PointCmp implements Comparator<Point> {
     public int compare(Point a, Point b) {
         if (a.time == b.time) {
             return a.flag - b.flag;
         }
         return a.time - b.time;
     }
 }

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        List<Point> list = new ArrayList<>();
        for (Interval elem : intervals) {
            list.add(new Point(elem.start, 1));
            list.add(new Point(elem.end, -1));
        }
        Collections.sort(list, new PointCmp());
        int count = 0;
        for (Point point : list) {
            if (point.flag == 1) {
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
