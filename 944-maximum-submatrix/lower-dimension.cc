class Solution {
public:
    /**
     * @param matrix: the given matrix
     * @return: the largest possible sum
     */
    int maxSubmatrix(vector<vector<int>> &matrix) {
        // write your code here
        if (matrix.size() == 0) {
            return 0;
        }
        if (matrix[0].size() == 0) {
            return 0;
        }
        int row = matrix.size();
        int col = matrix[0].size();
        vector<vector<int>> prefix_sum_col = getPrefixSum(matrix);
        int max_size = INT_MIN;
        for (int up = 0; up != row; ++up) {
            for (int down = up; down != row; ++down) {
                vector<int> array = compression(matrix, up, down, prefix_sum_col);
                max_size = max(max_size, maxSubarray(array));
            }
        }
        return max_size;
    }
    int maxSubarray(vector<int>& array) {
        int sum = 0; 
        int min = 0;
        int max = INT_MIN;
        for (int i = 0; i != array.size(); ++i) {
            sum += array[i];
            max = std::max(sum - min, max);
            min = std::min(sum, min);
        }
        return max;
    }
    vector<int> compression(vector<vector<int>>& matrix, int up, int down, vector<vector<int>>& prefix_sum_col) {
        int col = matrix[0].size();
        vector<int> array(col, 0);
        for (int i = 0; i != col; ++i) {
            array[i] = prefix_sum_col[down + 1][i] - prefix_sum_col[up][i];
        }
        return array;
    }
    vector<vector<int>> getPrefixSum(vector<vector<int>>& matrix) {
        int row = matrix.size();
        int col = matrix[0].size();
        vector<vector<int>> prefix_sum_col(row + 1, vector<int>(col, 0));
        for (int i = 0; i != row; ++i) {
            for (int j = 0; j != col; ++j) {
                prefix_sum_col[i + 1][j] = matrix[i][j] + prefix_sum_col[i][j];
            }
        }
        return prefix_sum_col;
    }
};
