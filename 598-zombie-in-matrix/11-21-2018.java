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
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        // write your code here
        int countW = 0;
        int countZ = 0;
        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    countZ++;
                    q.add(new Point(i, j));
                } else if (grid[i][j] == 2) {
                    countW++;
                }
            } 
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;
        while (!q.isEmpty()) {
            if (countZ + countW == total) {
                return count;
            }
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point point = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = point.x + dx[j];
                    int nextY = point.y + dy[j];
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                        continue;
                    }
                    if (grid[nextX][nextY] == 0) {
                        countZ++;
                        grid[nextX][nextY] = 1;
                        q.add(new Point(nextX, nextY));
                    }
                }
            }
        }
        return countZ + countW == total ? count : -1; 
    }
}
