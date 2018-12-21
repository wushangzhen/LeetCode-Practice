public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return false;
        }
        char c = word.charAt(0);
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == c) {
                    if (dfs(0, i, j, board, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean dfs(int index, int x, int y, char[][] board, String word, boolean[][] visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length 
            || visited[x][y] || index > word.length()) {
            return false;
        }
        if (index == word.length() - 1) {
            if (board[x][y] == word.charAt(index)) {
                return true;
            } else {
                return false;
            }
        }
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        boolean match = false;
        visited[x][y] = true;
        match = dfs(index + 1, x + 1, y, board, word, visited) || dfs(index + 1, x - 1, y, board, word, visited) || dfs(index + 1, x, y + 1, board, word, visited) || dfs(index + 1, x, y - 1, board, word, visited);
        visited[x][y] = false;
        return match;
    }
}
