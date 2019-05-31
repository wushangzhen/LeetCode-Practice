class Solution {
    int[][][] memo;
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        memo = new int[N][N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(memo[i][j], Integer.MIN_VALUE);
            }
        }
        return Math.max(0, dp(0, 0, 0, grid));
    }
    int dp(int r1, int c1, int r2, int[][] grid) {
        int c2 = r1 + c1 - r2;
        if (r1 >= grid.length || c1 >= grid.length
            || r2 >= grid.length || c2 >= grid.length 
            || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -1;
        }
        if (r1 == grid.length - 1 && c1 == grid.length - 1) {
            return grid[r1][c1];
        } 
        if (memo[r1][c1][r2] != Integer.MIN_VALUE) {
            return memo[r1][c1][r2];
        }
        memo[r1][c1][r2] = Math.max(Math.max(dp(r1 + 1, c1, r2, grid), dp(r1, c1 + 1, r2, grid)),
                                    Math.max(dp(r1 + 1, c1, r2 + 1, grid), dp(r1, c1 + 1, r2 + 1, grid)));
        if (memo[r1][c1][r2] == -1) {
            return -1;
        }
        memo[r1][c1][r2] += grid[r1][c1];
        if (r1 != r2) {
            memo[r1][c1][r2] += grid[r2][c2];
        }
        return memo[r1][c1][r2];
                                    
    }
}
