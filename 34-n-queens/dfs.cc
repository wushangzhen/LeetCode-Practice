class Solution {
public:
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    int totalNQueens(int n) {
        // write your code here
        if (n <= 0) {
            return 0;
        }
        int result = 0;
        vector<int> col;
        search(result, col, n);
        return result;
    }
    void search(int& result, vector<int>& col, int n) {
        if (col.size() == n) {
            result++;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(col, i)) {
                continue;
            }
            col.push_back(i);
            search(result, col, n);
            col.pop_back();
        }
    }
    bool isValid(vector<int>& col, int colomn) {
        int row = col.size();
        for (int i = 0; i < col.size(); i++) {
            if (col[i] == colomn) {
                return false;
            }
            if (row - i == colomn - col[i]) {
                return false;
            }
            if (row - i == col[i] - colomn) {
                return false;
            }
        }
        return true;
    }
};
