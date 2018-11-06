class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] left = new int[n][m];
        int[][] right = new int[n][m];
        int[][] up = new int[n][m];
        int[][] down = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 'W') {
                    if (j != 0) {
                       left[i][j] = left[i][j - 1]; 
                    }
                    if (grid[i][j] == 'E') {
                        left[i][j]++;
                    } 
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] != 'W') {
                    if (j != m - 1) {
                       right[i][j] = right[i][j + 1]; 
                    }
                    if (grid[i][j] == 'E') {
                        right[i][j]++;
                    } 
                }
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (grid[i][j] != 'W') {
                    if (i != 0) {
                       up[i][j] = up[i - 1][j]; 
                    }
                    if (grid[i][j] == 'E') {
                        up[i][j]++;
                    } 
                }
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] != 'W') {
                    if (i != n - 1) {
                        down[i][j] = down[i + 1][j]; 
                    }
                    if (grid[i][j] == 'E') {
                        down[i][j]++;
                    } 
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') {
                    res = Math.max(res, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        return res;
    }
}
