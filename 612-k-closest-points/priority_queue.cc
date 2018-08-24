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
Point globalOrigin;
int distanceSquare(const Point& a, const Point& b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
}
struct Cmp {
    bool operator()(const Point& a, const Point& b) {
        int diff = distanceSquare(a, globalOrigin) - distanceSquare(b, globalOrigin);
        if (diff == 0) {
            diff = a.x - b.x;
        } 
        if (diff == 0) {
            diff = a.y - a.y;
        }
        return diff < 0;
    }
};
class Solution {
public:
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    
    vector<Point> kClosest(vector<Point> &points, Point &origin, int k) {
        // write your code here
        globalOrigin = Point(origin.x, origin.y); // this is necessary
        priority_queue<Point, vector<Point>, Cmp> priQue;
        for (int i = 0; i < points.size(); i++) {
            if (priQue.size() < k) {
                priQue.push(points[i]);
            } else {
                priQue.push(points[i]);
                priQue.pop();
            }
        }
        vector<Point> result;
        while (priQue.size() != 0) {
            Point top = priQue.top();
            priQue.pop();
            result.push_back(top);
        }
        reverse(result.begin(), result.end());
        return result; 
        
    }
    
};
