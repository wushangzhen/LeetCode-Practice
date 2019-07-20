class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    boolean helper(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (helper(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean isValid(char[][] board, int x, int y, char c) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[x][i] == c) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == c) {
                return false;
            }
        }
        int xx = x / 3 * 3;
        int yy = y / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[xx + i][yy + j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
