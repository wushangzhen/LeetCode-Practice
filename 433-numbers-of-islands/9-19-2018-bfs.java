class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null) {
            return 0;
        }
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        if (grid[0] == null) {
            return 0;
        }
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        int[] deltaX = {0, 0, 1, -1};
        int[] deltaY = {1, -1, 0, 0};
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]){
                    queue.offer(new Point(i, j));
                    grid[i][j] = false;
                    count++;
                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nextX = point.x + deltaX[k];
                            int nextY = point.y + deltaY[k];
                            if (inBound(nextX, nextY, grid) && grid[nextX][nextY]) {
                                queue.add(new Point(nextX, nextY));
                                grid[nextX][nextY] = false;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    private boolean inBound(int x, int y, boolean[][] grid) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            return true;
        }
        return false;
        
    }
}
