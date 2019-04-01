class Solution {
    Boolean[][] pacific;
    Boolean[][] atlantic;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null) {
            return res;
        }
        int n = matrix.length;
        if (n == 0 || matrix[0] == null) {
            return res;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return res;
        }
        pacific = new Boolean[n][m];
        atlantic = new Boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pacific[i][j] = dfs1(i, j, matrix, new boolean[n][m]);
                atlantic[i][j] = dfs2(i, j, matrix, new boolean[n][m]);
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }
    public boolean dfs1(int x, int y, int[][] matrix, boolean[][] visited) {
        if (pacific[x][y] != null) {
            return pacific[x][y];
        }
        visited[x][y] = true;
        boolean res = false;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx < 0 || yy < 0) {
                res = true;
                break;
            }
            if (xx >= matrix.length || yy >= matrix[0].length || visited[xx][yy]) {
                continue;
            } else if (matrix[xx][yy] <= matrix[x][y]) {
                res = res || dfs1(xx, yy, matrix, visited);
            }
        }
        visited[x][y] = false;
        return res;
    }
    public boolean dfs2(int x, int y, int[][] matrix, boolean[][] visited) {
        if (atlantic[x][y] != null) {
            return atlantic[x][y];
        }
        visited[x][y] = true;
        boolean res = false;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= matrix.length || yy >= matrix[0].length) {
                res = true;
                break;
            }
            if (xx < 0 || yy < 0 || visited[xx][yy]) {
                continue;
            } else if (matrix[xx][yy] <= matrix[x][y]) {
                res = res || dfs2(xx, yy, matrix, visited);
            }
        }
        visited[x][y] = false;
        return res;
    }
}
