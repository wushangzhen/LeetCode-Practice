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
     * @param grid: a 2D array
     * @return: the maximum area of an island in the given 2D array
     */
    public int maxAreaOfIsland(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<Point> q = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 0;
                if (grid[i][j] == 1) {
                    q.add(new Point(i, j));
                    grid[i][j] = 0;
                    while (!q.isEmpty()) {
                        Point point = q.poll();
                        count++;
                        for (int k = 0; k < 4; k++) {
                            int nextX = point.x + dx[k];
                            int nextY = point.y + dy[k];
                            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m && grid[nextX][nextY] == 1) {
                                q.add(new Point(nextX, nextY));
                                grid[nextX][nextY] = 0;
                            }
                        }
                    }
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
