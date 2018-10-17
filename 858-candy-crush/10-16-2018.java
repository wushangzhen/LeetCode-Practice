class Solution {
    public int[][] candyCrush(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean toDo = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 2; j++) {
                int v = Math.abs(board[i][j]);
                if (v != 0 && v == Math.abs(board[i][j + 1]) && v == Math.abs(board[i][j + 2])) {
                    board[i][j + 1] = board[i][j] = board[i][j + 2] = -v;
                    toDo = true;
                }
            }  
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n - 2; i++) {
                int v = Math.abs(board[i][j]);
                if (v != 0 && v == Math.abs(board[i + 1][j]) && v == Math.abs(board[i + 2][j])) {
                    board[i + 1][j] = board[i][j] = board[i + 2][j] = -v;
                    toDo = true;
                }
            }  
        }
        for (int j = 0; j < m; j++) {
            int wr = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (board[i][j] > 0) {
                    board[wr--][j] = board[i][j];
                }
            }
            while (wr >= 0) {
                board[wr--][j] = 0;
                
            }
        }
        return toDo ? candyCrush(board) : board;
    }
}
