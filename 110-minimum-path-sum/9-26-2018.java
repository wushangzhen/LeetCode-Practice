public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null) {
            return -1;
        }
        int n = grid.length;
        if (n == 0) {
            return -1;
        }
        int m = grid[0].length;
        if (m == 0) {
            return -1;
        } 
        int[][] f = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                if (i == 0 && j == 0) {
                    f[i][j] = grid[i][j];
                    continue;
                }
                if (i == 0) {
                    f[i][j] = f[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    f[i][j] = f[i - 1][j] + grid[i][j];
                    continue;
                }
                int min = Math.min(f[i - 1][j], f[i][j - 1]);
                f[i][j] = min + grid[i][j];
            }
        }
        return f[n - 1][m - 1];
    }
}
