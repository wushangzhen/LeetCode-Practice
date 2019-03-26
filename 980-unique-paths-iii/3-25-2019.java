class Solution {
    int res = 0;
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int todo = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 1) {
                    todo++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, visited, grid, todo);
                }
            }
        }
        return res;
    }
    void dfs(int x, int y, boolean[][] visited, int[][] grid, int todo) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == -1) {
            return;
        }
        if (grid[x][y] == 2) {
            if (todo == 0) {
                res++;
            }
            return;
        }
        todo--;
        visited[x][y] = true;
        dfs(x + 1, y, visited, grid, todo);
        dfs(x - 1, y, visited, grid, todo);
        dfs(x, y + 1, visited, grid, todo);
        dfs(x, y - 1, visited, grid, todo);
        todo++;
        visited[x][y] = false;
    }
}
