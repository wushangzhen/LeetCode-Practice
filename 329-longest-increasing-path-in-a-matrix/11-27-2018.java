class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(dfs(i, j, n, m, matrix, memo), max);
            }
        }
        return max;
    }
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int dfs(int x, int y, int n, int m, int[][] matrix, int[][] memo) {
        if (memo[x][y] != 0) {
            return memo[x][y]; 
        }
        int res = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m && matrix[nextX][nextY] > matrix[x][y]) {
                res = Math.max(res, dfs(nextX, nextY, n, m, matrix, memo) + 1);
            }
        }
        memo[x][y] = res;
        return res;
        
    }
}
