class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        int[][] f = new int[2][m];
        int old = 0;
        int now = 0;
        //f[now][0] = grid[0][0];
        for (int i = 0; i < n; i++) {
            old = now;
            now = 1 - now;
            for (int j = 0; j < m; j++) {   
                if (i == 0 && j == 0) {
                    f[now][j] = grid[0][0];
                    continue;
                }
                if (i == 0 && j != 0) {
                    f[now][j] = f[now][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0 && i != 0) {
                    f[now][j] = f[old][j] + grid[i][j];
                    continue;
                }
                f[now][j] = Math.min(f[old][j], f[now][j - 1]) + grid[i][j];
            }
        }
        return f[now][m - 1];
        
    }
}
