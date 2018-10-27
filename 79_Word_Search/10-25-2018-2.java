class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && dfs(word, visited, i, j, 0, board)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(String word, boolean[][] visited, int i, int j, int index, char[][] board) {
        int n = board.length;
        int m = board[0].length;
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean result = dfs(word, visited, i - 1, j, index + 1, board) || dfs(word, visited, i + 1, j, index + 1, board)
            || dfs(word, visited, i, j - 1, index + 1, board) || dfs(word, visited, i, j + 1, index + 1, board);
        visited[i][j] = false;
        return result;
    }
}
