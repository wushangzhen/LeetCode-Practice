class Solution {
    public int numEnclaves(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        } 
        int n = A.length;
        int m = A[0].length;
        if (m == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (A[i][0] == 1) {
                dfs(i, 0, A);
            }
            if (A[i][m - 1] == 1) {
                dfs(i, m - 1, A);
            }
        }
        for (int j = 0; j < m; j++) {
            if (A[0][j] == 1) {
                dfs(0, j, A);
            }
            if (A[n - 1][j] == 1) {
                dfs(n - 1, j, A);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public void dfs(int x, int y, int[][] A) {
        A[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx < 0 || xx >= A.length || yy < 0 || yy >= A[0].length || A[xx][yy] == 0) {
                continue;
            }
            dfs(xx, yy, A);
        }
    } 
}
