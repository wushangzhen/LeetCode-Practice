#include <unordered_set>
#include <queue>
#include <iostream>
using namespace std;
//Definition for a point.
struct Point {
    int x;
    int y;
    Point() : x(0), y(0) {}
    Point(int a, int b) : x(a), y(b) {}
    bool operator == (const Point &t) const {
        return x == t.x && y == t.y;
    }
};
struct Point_Hash {
    size_t operator()(const struct Point& _t) const {
        return _t.x * 100 + _t.y; 
    }
};


class Solution {
public:
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    static int shortestPath(vector<vector<bool> > &grid, Point &source, Point &destination) {
        // write your code here
        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }
        int deltaX[] = {1, 1, -1, -1, 2, 2, -2, -2};
        int deltaY[] = {2, -2, 2, -2, 1, -1, 1, -1};
        queue<Point> que1;
        queue<Point> que2;
        que1.push(source);
        que2.push(destination);
        unordered_set<Point, Point_Hash> set1;
        unordered_set<Point, Point_Hash> set2;
        set1.insert(source);
        set2.insert(destination);
        int step = 0;
        while (!que1.empty() || !que2.empty()) {
            step++;
            int size1 = que1.size();
            int size2 = que2.size();
            for (int j = 0; j < size1; j++) {
                Point head = que1.front();
                que1.pop();
                for (int i = 0; i < 8; i++) {
                    if (isBound(grid, head, deltaX[i], deltaY[i]) ) {
                        Point neighbor(head.x + deltaX[i], head.y + deltaY[i]);
                        if (set2.find(neighbor) != set2.end()) {
                            return step;
                        }
                        if (!grid[neighbor.x][neighbor.y] && set1.find(neighbor) == set1.end()) {
                            set1.insert(neighbor);
                            que1.push(neighbor);
                        }
                    }
                }
            }
            step++;
            for (int j = 0; j < size2; j++) {
                Point head = que2.front();
                que2.pop();
                for (int i = 0; i < 8; i++) {
                    if (isBound(grid, head, deltaX[i], deltaY[i]) ) {
                        Point neighbor(head.x + deltaX[i], head.y + deltaY[i]);
                        if (set1.find(neighbor) != set1.end()) {
                            return step;
                        }
                        if (!grid[neighbor.x][neighbor.y] && set2.find(neighbor) == set2.end()) {
                            set2.insert(neighbor);
                            que2.push(neighbor);
                        }
                    }
                }
            }
        }
        return -1;
    }
private:
    static bool isBound(vector<vector<bool> > &grid, Point &point, int dx, int dy) {
        if (point.x + dx >= 0 && point.y + dy >= 0 && point.x + dx <= grid.size() - 1 && point.y + dy <= grid[0].size() - 1) {
            return true;
        }
        return false;
    }
};

int main() {
    vector<vector<bool> > input; 
    vector<bool> vec;
    vec = {false, true, false}; 
    input.push_back(vec);
    vec = {false, false, true}; 
    input.push_back(vec);
    vec = {false, false, false}; 
    input.push_back(vec);
    Point start(2, 0);
    Point end(2, 2);
    cout << Solution::shortestPath(input, start, end) << endl;
}
