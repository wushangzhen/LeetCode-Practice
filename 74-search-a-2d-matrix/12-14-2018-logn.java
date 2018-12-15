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
        int row = binarySearch(target, matrix);
        int start = 0;
        int end = m - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        }
        if (matrix[row][end] == target) {
            return true;
        }
        return false;
    }
    int binarySearch(int target, int[][] matrix) {
        int start = 0;
        int end = matrix.length - 1;
        int n = matrix[0].length;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (matrix[mid][n - 1] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (target > matrix[start][n - 1]) {
            return end;
        }
        return start;
    }
}
