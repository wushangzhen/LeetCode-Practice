class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }
        grid[i][j] = '0';
        if (i + 1 < n && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j, n, m);
        }
        if (0 <= i - 1 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j, n, m);
        }
        if (j + 1 < m && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1, n, m);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1, n, m);
        }
    }
}
