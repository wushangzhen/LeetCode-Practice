struct Coordinate {
    int x;
    int y;
    Coordinate(int x, int y) {
        this->x = x;
        this->y = y;
    }
};
class Solution {
public:
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    int PEOPLE = 0;
    int ZOMBIE = 1;
    int WALL = 2;
    int people = 0;
    int deltaX[4] = {0, 0, -1, 1};
    int deltaY[4] = {1, -1, 0, 0};
    int zombie(vector<vector<int>> &grid) {
        // write your code here
        if (grid.empty() || grid[0].empty()) {
            return 0;
        }
        queue<Coordinate*> que;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[i].size(); j++) {
                if (grid[i][j] == ZOMBIE) {
                    que.push(new Coordinate(i, j));
                } else if (grid[i][j] == 0) {
                    people++;
                }
            }
        }
        if (people == 0) {
            return 0;
        }
        int days = 0;
        while (!que.empty()) {
            int size = que.size();
            days++;
            for (int i = 0; i < size; i++) {
                Coordinate* temp = que.front();
                que.pop();
                for (int j = 0; j < 4; j++) {
                    int adjX = temp->x + deltaX[j];
                    int adjY = temp->y + deltaY[j];
                    if (Inbound(adjX, adjY, grid)) {
                        if (grid[adjX][adjY] == PEOPLE) {
                            people--;
                            grid[adjX][adjY] = ZOMBIE;
                            if (people == 0) {
                                return days;
                            }
                            que.push(new Coordinate(adjX, adjY));
                        }
                    }
                }
            }
        }
        return -1;
    }
    bool Inbound(int x, int y, vector<vector<int>>& grid) {
        if (x >= 0 && y >= 0 && x < grid.size() && y < grid[0].size()) {
            return true;
        }
        return false;
    }
};
