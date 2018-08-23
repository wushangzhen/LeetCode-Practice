class Solution {
public:
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    vector<vector<string>> solveNQueens(int n) {
        // write your code here
        vector<vector<string>> results;
        if (n <= 0) {
            return results;
        }
        vector<int> cols;
        search(results, cols, n);
        return results;
    }
    void search(vector<vector<string>>& results, vector<int>& cols, int n) {
        if (cols.size() == n) {
            results.push_back(drawChessBoard(cols));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(cols, i)) {
                continue;
            }
            cols.push_back(i);
            search(results, cols, n);
            cols.pop_back();
        }
    }
    vector<string> drawChessBoard(vector<int>& cols) {
        vector<string> result;
        for (int j = 0; j < cols.size(); j++) {
            string str = "";
            for (int i = 0; i < cols.size(); i++) {
                if (i == cols[j]) {
                    str += "Q";
                } else {
                    str += ".";
                }
            }
            result.push_back(str);
        }
        return result;
    }
    bool isValid(vector<int>& cols, int colomn) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            if (cols[i] == colomn) {
                return false;
            }
            if (colomn - cols[i] == row - i) {
                return false;
            }
            if (cols[i] - colomn == row - i) {
                return false;
            }
        }
        return true;
    }
};
