/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

//Definition for a point.
class Point1 {
    double x;
    double y;
    Point1() { x = 0.0; y = 0.0; }
    Point1(double a, double b) { x = a; y = b; }
}

public class Solution {
    /**
     * @param l1: top-left coordinate of first rectangle
     * @param r1: bottom-right coordinate of first rectangle
     * @param l2: top-left coordinate of second rectangle
     * @param r2: bottom-right coordinate of second rectangle
     * @return: true if they are overlap or false
     */
    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        // write your code here
        Point1 center1 = new Point1((double)(l1.x + r1.x) / 2, (double)(l1.y + r1.y) / 2);
        Point1 center2 = new Point1((double)(l2.x + r2.x) / 2, (double)(l2.y + r2.y) / 2);
        double length1x = Math.abs(r1.x - l1.x);
        double length1y = Math.abs(r1.y - l1.y);
        double length2x = Math.abs(r2.x - l2.x);
        double length2y = Math.abs(r2.y - l2.y);
        if (Math.abs(center2.x - center1.x) * 2 <= length1x + length2x 
            && Math.abs(center1.y - center2.y) * 2 <= length1y + length2y) {
                return true;
        }
        return false;
        
    }
}
