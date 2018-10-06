public class Solution {
    /**
     * @param board: the board
     * @return: whether the Sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {
        // write your code here
        if (board == null || board.length == 0) {
            return false;
        }
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < m; j++) {
                if (!map.containsKey(board[i][j])) {
                    map.put(board[i][j], 1);
                } else if (board[i][j] != '.' && map.get(board[i][j]) == 1) {
                    return false;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!map.containsKey(board[i][j])) {
                    map.put(board[i][j], 1);
                } else if (board[i][j] != '.' && map.get(board[i][j]) == 1) {
                    return false;
                }
            }
        }
        boolean flag = true;
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < m; j += 3) {
                flag = check(i, j, board);
                if (flag == false) {
                    return false;
                }
            }
        }
        return flag;
    }
    boolean check(int x, int y, char[][] board) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (!map.containsKey(board[i][j])) {
                    map.put(board[i][j], 1);
                } else if (board[i][j] != '.' && map.get(board[i][j]) == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
