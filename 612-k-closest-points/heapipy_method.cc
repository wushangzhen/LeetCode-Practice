/**
 * Definition for a point.
 * struct Point {
 *     int x;
 *     int y;
 *     Point() : x(0), y(0) {}
 *     Point(int a, int b) : x(a), y(b) {}
 * }; * Definition for a point.
 * struct Point {
 *     int x;
 *     int y;
 *     Point() : x(0), y(0) {}
 *     Point(int a, int b) : x(a), y(b) {}
 * };
 */

class Solution {
public:
    Point origin;
    int size;
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    vector<Point> kClosest(vector<Point> &points, Point &origin, int k) {
        // write your code here
        if (points.empty()) {
            return points;
        }
        this->origin = origin;
        heapify(points);
        vector<Point> results;
        for (int i = 0; i < k; i++) {
            Point result = pop(points);
            results.push_back(result);
        }
        return results;
    }
    void heapify(vector<Point>& points) {
        this->size = points.size();
        for (int i = size / 2; i >= 0; i--) {
            siftDown(points, i);
        }
    }
    void siftDown(vector<Point>& points, int index) {
        while (index < size) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int min = index;
            if (left < size && compare(points[min], points[left]) > 0) {
                min = left;
            }
            if (right < size && compare(points[min], points[right]) > 0) {
                min = right;
            }
            if (index != min) {
                Point temp = points[index];
                points[index] = points[min];
                points[min] = temp;
                index = min;
            } else {
                break;
            }
        }
    }
    Point pop(vector<Point>& points) {
        Point top = points[0];
        points[0] = points[size - 1];
        this->size--;
        siftDown(points, 0);
        return top;
    }
    int compare(Point a, Point b) {
        int square = distanceSquare(a, origin) - distanceSquare(b, origin);
        if (square != 0) {
            return square;
        }
        if (a.x != b.x) {
            return a.x - b.x;
        }
        return a.y - b.y;
    }
    int distanceSquare(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
};
// O(n + klogn)
