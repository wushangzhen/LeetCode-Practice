class Coordinate {
public:
    int x, y;
    Coordinate(int _x, int _y) {
        x = _x;
        y = _y;
    }
};
class Solution {
public:
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    int numIslands(vector<vector<bool>> &grid) {
        // write your code here
        if (grid.empty() || grid[0].empty()) {
            return 0;
        } 
        int m = grid.size();
        int n = grid[0].size();
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    markByBFS(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    void markByBFS(vector<vector<bool>> &grid, int i, int j) {
        int coordinateX[4] = {0, 1, -1, 0};
        int coordinateY[4] = {1, 0, 0, -1};
        queue<Coordinate> que;
        que.push(Coordinate(i, j));
        grid[i][j] = false;
        while (!que.empty()) {
            Coordinate coor = que.front();
            que.pop();
            for (int k = 0; k < 4; k++) {
                Coordinate adj = Coordinate(coor.x + coordinateX[k], coor.y + coordinateY[k]);
                if (!inBound(adj, grid)) {
                    continue;
                }
                if (grid[adj.x][adj.y]) {
                    grid[adj.x][adj.y] = false;
                    que.push(adj);
                }
            }
        }
    }
    bool inBound(Coordinate &adj, vector<vector<bool>> &grid) {
        if (adj.x < grid.size() && adj.y < grid[0].size() && adj.x >= 0 && adj.y >= 0) {
            return true;
        }
        return false;
    }
};
