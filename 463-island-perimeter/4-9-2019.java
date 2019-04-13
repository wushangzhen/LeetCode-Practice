class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return helper(i, j, grid);
                }
            } 
        }
        return 0;
    }
    int helper(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == -1) {
            return 0;
        }
        grid[x][y] = -1;
        int ans = 0;
        ans += helper(x + 1, y, grid);
        ans += helper(x, y + 1, grid);
        ans += helper(x, y - 1, grid);
        ans += helper(x - 1, y, grid);
        return ans;
    }
}
