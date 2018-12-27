/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public int computeDistance(Point a) {
        return (a.x - origin.x) * (a.x - origin.x) + (a.y - origin.y) * (a.y - origin.y);
    }
    public int compare(Point a, Point b) {
        int res = computeDistance(a) - computeDistance(b);
        if (res == 0) {
            if (a.x == b.x) {
                return a.y - b.y;
            }
            return a.x - b.x;
        }
        return res;
    }
    private int size;
    Point origin;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        if (points == null || points.length == 0) {
            return new Point[0];
        }
        this.origin = origin;
        Point[] ps = new Point[k];
        this.size = points.length;
        heapify(points);
        for (int i = 0; i < k; i++) {
            ps[i] = pop(points);
        }
        return ps;
    }
    void heapify(Point[] points) {
        for (int i = points.length / 2; i >= 0; i--) {
            siftDown(points, i);
        }
    }
    void siftDown(Point[] points, int index) {
        while (index < size) {
            int son1 = index * 2 + 1;
            int son2 = index * 2 + 2;
            int son = son1;
            if (son1 < size && son2 < size) {
                if (compare(points[son1], points[son2]) > 0) {
                    son = son2;
                }
            }
            if (son < size && compare(points[index], points[son]) > 0) {
                Point temp = points[index];
                points[index] = points[son];
                points[son] = temp;
                index = son;
            } else {
                break;
            }
        }
    }
    Point pop(Point[] points) {
        Point top = points[0];
        points[0] = points[size - 1];
        size--;
        siftDown(points, 0);
        return top;
    }
}
