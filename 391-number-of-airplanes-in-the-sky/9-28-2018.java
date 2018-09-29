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
 }
 class PointComparator implements Comparator<Point> {
     public int compare (Point left, Point right) {
         if (left.time == right.time) {
             return left.flag - right.flag;
         } else {
             return left.time - right.time;
         }
     }
 }

public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        List<Point> list = new ArrayList<>();
        for (Interval i : airplanes) {
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }
        Collections.sort(list, new PointComparator());
        int count = 0;
        int ans = 0;
        for (Point point : list) {
            if (point.flag == 1) {
                count++;
            } else {
                count--;
            }
            ans = Math.max(count, ans);
        }
        return ans;
        
    }
}
