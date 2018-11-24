class Solution {
    public boolean exist(char[][] board, String word) {
        char c = word.charAt(0);
        int n = board.length;
        int m = board[0].length;
        int len = word.length();
        boolean res = false;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == c) {
                    res = dfs(0, i, j, word, board, visited);
                    if (res) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
    boolean dfs(int start, int x, int y, String word, char[][] board, boolean[][] visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return false;
        }
        if (start >= word.length()) {
            return false;
        }
        if (start == word.length() - 1) {
            if (board[x][y] == word.charAt(start)) {
                return true;
            }
        }
        if (board[x][y] != word.charAt(start)) {
            return false;
        }
        visited[x][y] = true;
        boolean res = dfs(start + 1, x + 1, y, word, board, visited) || dfs(start + 1, x - 1, y, word, board, visited)
            || dfs(start + 1, x, y - 1, word, board, visited) || dfs(start + 1, x, y + 1, word, board, visited);
        visited[x][y] = false;
        return res;
    }
}
