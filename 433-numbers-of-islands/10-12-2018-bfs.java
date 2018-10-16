class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int count = 0;
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    q.add(new Point(i, j));
                    while (!q.isEmpty()) {
                        Point p = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nextx = p.x + dx[k];
                            int nexty = p.y + dy[k];
                            if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) {
                                continue;
                            }
                            if (grid[nextx][nexty] == '1') {
                                q.add(new Point(nextx, nexty));
                                grid[nextx][nexty] = '0';
                            }
                        }
                    }
                }
            }
        } 
        return count;
    }
}
