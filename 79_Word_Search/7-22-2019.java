class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        char[] sc = word.toCharArray();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(i, j, 1, sc, visited, board)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    boolean dfs(int x, int y, int k, char[] sc, boolean[][] visited, char[][] board) {
        if (k == sc.length) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx < 0 || xx >= board.length || yy < 0 || yy >= board[0].length || visited[xx][yy] || board[xx][yy] != sc[k]) {
                continue;
            }
            visited[xx][yy] = true;
            if (dfs(xx, yy, k + 1, sc, visited, board)) {
                return true;
            }
            visited[xx][yy] = false;
        }
        return false;
    }
}
