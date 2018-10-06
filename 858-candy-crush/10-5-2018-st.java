public class Solution {
    /**
     * @param board: a 2D integer array
     * @return: the current board
     */
    public int[][] candyCrush(int[][] board) {
        // Write your code here
        if (board == null || board.length == 0) {
            return board;
        }
        int n = board.length;
        int m = board[0].length;
        boolean toDo = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j + 2 < m; j++) {
                int v = Math.abs(board[i][j]);
                if (v != 0 && v == Math.abs(board[i][j + 1]) && v == Math.abs(board[i][j + 2])) {
                     board[i][j] = board[i][j + 1] = board[i][j + 2] = -v;
                     toDo = true;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i + 2 < n; i++) {
                int v = Math.abs(board[i][j]); // abs is important because some value has been change to negative
                System.out.println(board[i][j]);
                if (v != 0 && v == Math.abs(board[i + 1][j]) && v == Math.abs(board[i + 2][j])) {
                     board[i][j] = board[i + 1][j] = board[i + 2][j] = -v;
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
            while (wr != -1) {
                board[wr--][j] = 0;
            }
        }
        return toDo ? candyCrush(board) : board;
    }
}
