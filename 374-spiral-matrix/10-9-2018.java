public class Solution {
    /**
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int rowStart = 0;
        int rowEnd = m - 1;
        int colStart = 0;
        int colEnd = n - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                   result.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return result;
    }
}
