class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        dfs(grid, r0, c0, grid[r0][c0]);
        for (int[] g : grid) {
            for (int i = 0; i < g.length; i++) {
                if (g[i] < 0) {
                    g[i] = color;
                }
            }
        }
        return grid;
    }
    void dfs(int[][] grid, int r0, int c0, int clr) {
        grid[r0][c0] = -clr;
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = r0 + dx[i];
            int ny = c0 + dy[i];
            if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || Math.abs(grid[nx][ny]) != clr) {
                continue;
            }
            cnt++;
            if (grid[nx][ny] == clr) {
                dfs(grid, nx, ny, clr);
            }
        }
        if (cnt == 4) {
            grid[r0][c0] = clr;
        }
    }
}
