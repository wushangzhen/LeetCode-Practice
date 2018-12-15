class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        if (m == 0) {
            return false;
        }
        int x = 0;
        int y = m - 1;
        while (x < n && y >= 0) {
            if (target == matrix[x][y]) {
                return true;
            }
            if (target < matrix[x][y]) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
