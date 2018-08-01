#include <vector>
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
        int m = matrix.size() - 1;
        if (matrix[0].size() == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[i].size();
        while (i < m && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            }
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            }
        }
    }
};
