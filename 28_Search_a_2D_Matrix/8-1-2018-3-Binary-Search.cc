class Solution {
public:
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    bool searchMatrix(vector<vector<int>> &matrix, int target) {
        // write your code here
        if (matrix.size() == 0) {
            return false;
        }
        int m = matrix.size();
        if (matrix[0].size() == 0) {
            return false;
        }
        int n = matrix[0].size();
        int start = 0;
        int end = n * m - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int row = mid / m;
            int column = mid % m;
            if (matrix[row][column] == target) {
                return true;
            }
            if (matrix[row][column] < target) {
                start = mid;
            }
            if (matrix[row][column] > target) {
                end = mid;
            }
        }
        if (matrix[start / m][start % m] == target) {
            return true;
        }
        if (matrix[end / m][end % m] == target) {
            return true;
        }
        return false;
    }
};
int main() {

}
