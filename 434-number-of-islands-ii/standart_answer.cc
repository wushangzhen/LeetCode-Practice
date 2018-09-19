/**
 * Definition for a point.
 * struct Point {
 *     int x;
 *     int y;
 *     Point() : x(0), y(0) {}
 *     Point(int a, int b) : x(a), y(b) {}
 * };
 */

class Solution {
public:
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    vector<int> numIslands2(int n, int m, vector<Point> &operators) {
        // write your code here
        vector<int> result;
        int xs[4] = {0, 0, 1, -1};
        int ys[4] = {1, -1, 0, 0};
        for (int i = 0; i < operators.size(); ++i) {
            int x = operators[i].x;
            int y = operators[i].y;
            int coordinate = m * x + y;
            if (fathers.find(coordinate) != fathers.end()) {
                result.push_back(total);
                continue;
            }
            total++;
            fathers[coordinate] = coordinate;
            for (int j = 0; j < 4; ++j) {
                int X = x + xs[j];
                int Y = y + ys[j];
                int COORDINATE = m * X + Y;
                if (!(X >= 0 && X < n && Y >= 0 && Y < m)) {
                    continue;
                }
                if (fathers.find(COORDINATE) == fathers.end()) {
                    continue;
                }
                Union(coordinate, COORDINATE);
            }
            result.push_back(total);
        }
        return result;
    }
private:
    int total = 0;
    unordered_map<int, int> fathers;
    int Find (int i) {
        if (fathers[i] == i) {
            return i;
        }
        return fathers[i] = Find(fathers[i]);
    }
    void Union(int coordinate, int COORDINATE) {
        int dadOld = Find(COORDINATE);
        int dadNew = Find(coordinate);
        if (dadOld != dadNew) {
            fathers[dadNew] = dadOld;
            total--;
        }
    }
};
