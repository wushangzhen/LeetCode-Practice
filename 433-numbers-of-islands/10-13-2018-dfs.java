class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    markDfs(i, j, grid, n, m);
                    count++;
                }
            }
        }
        return count;
    }
    void markDfs(int i, int j, char[][] grid, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        markDfs(i + 1, j, grid, n, m);
        markDfs(i - 1, j, grid, n, m);
        markDfs(i, j + 1, grid, n, m);
        markDfs(i, j - 1, grid, n, m);
    }
}
