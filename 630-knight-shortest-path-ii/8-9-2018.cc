#include <iostream>
#include <queue>
using namespace std;
struct Point {
    int x;
    int y;
    Point(int _x, int _y) {
        x = _x;
        y = _y;
    }
};

class Solution {
public:
    /**
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    int shortestPath2(vector<vector<bool>> &grid) {
        // write your code here
        if (grid.empty()) {
            return -1;
        }
        int m = grid.size();
        int n = grid[0].size();
        int deltaX[] = {1, -1, 2, -2};
        int deltaY[] = {2, 2, 1, 1};
        queue<Point> que;
        Point start(0, 0);
        que.push(start);
        int step = 0;
        while (!que.empty()) {
            step++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point head = que.front();
                que.pop();
                for (int j = 0; j < 4; j++) {
                    if (head.x + deltaX[j] >= 0 && head.x + deltaX[j] < m
                        && head.y + deltaY[j] < n) {
                        if (head.x + deltaX[j] == m - 1 && head.y + deltaY[j] == n - 1) {
                            return step;
                        }
                        if (!(grid[head.x + deltaX[j]][head.y + deltaY[j]])) {
                            Point neighbor(head.x + deltaX[j], head.y + deltaY[j]);
                            que.push(neighbor);
                        }
                    }
                }
            }
        }
        return -1;
    }
};
int main() {
}
