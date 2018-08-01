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
        
        for (int i = matrix.size() - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[i].size(); j++) {
                if (matrix[i][j] > target) {
                    break;
                }
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
};
