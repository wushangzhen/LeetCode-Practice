class Point {
    public int x;
    public int y;
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
        Queue<Point> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    queue.offer(new Point(i, j));
                    grid[i][j] = false;
                    count++;
                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nextX = point.x + dx[k];
                            int nextY = point.y + dy[k];
                            if (nextX >= 0 && nextX < n && nextY >= 0 
                                && nextY < m && grid[nextX][nextY]) {
                                    queue.offer(new Point(nextX, nextY));
                                    grid[nextX][nextY] = false;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
