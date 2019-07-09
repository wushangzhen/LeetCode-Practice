class Solution {
    public boolean validTicTacToe(String[] board) {
        boolean xwin = false;
        boolean owin = false;
        int[] row = new int[3];
        int[] col = new int[3];
        int diag = 0;
        int anti = 0;
        int turn = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    turn++;
                    row[i]++;
                    col[j]++;
                    if (i == j) {
                        diag++;
                    }
                    if (i + j == 2) {
                        anti++;
                    }
                } else if (board[i].charAt(j) == 'O') {
                    turn--;
                    row[i]--;
                    col[j]--;
                    if (i == j) {
                        diag--;
                    }
                    if (i + j == 2) {
                        anti--;
                    }
                }
            }
        }
        xwin = row[0] == 3 || row[1] == 3 || row[2] == 3 || col[0] == 3 || col[1] == 3 || col[2] == 3 || diag == 3 || anti == 3;
        owin = row[0] == -3 || row[1] == -3 || row[2] == -3 || col[0] == -3 || col[1] == -3 || col[2] == -3 || diag == -3 || anti == -3;
        if ((xwin && turn == 0) || (owin && turn == 1)) {
            return false;
        }
        return (turn == 1 || turn == 0) && (!owin || !xwin);
    }
}
