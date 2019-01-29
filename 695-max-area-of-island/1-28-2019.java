class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        } 
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(bfs(i, j, grid), max);
                }
            }
        }
        return max;
    }
    int bfs(int x, int y, int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        grid[x][y] = 0;
        q.add(new int[]{x, y});
        int count = 0;
        while (!q.isEmpty()) {
            int[] top = q.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nx = top[0] + dx[i];
                int ny = top[1] + dy[i];
                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || grid[nx][ny] == 0) {
                    continue;
                }
                grid[nx][ny] = 0;
                q.add(new int[]{nx, ny});
            }
        }
        return count;
    }
}
