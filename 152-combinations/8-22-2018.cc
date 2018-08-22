class Solution {
public:
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    vector<vector<int>> combine(int n, int k) {
        // write your code here
        vector<vector<int>> results;
        vector<int> vec;
        if (n < 0 || k < 0) {
            return results;
        }
        dfs(results, vec, n, k, 0);
        return results;
    }
            
    void dfs(vector<vector<int>>& results, vector<int>& vec, int n, int k, int startindex) {
        if (vec.size() >= k) {
            results.push_back(vec);
            return;
        }
        for (int i = startindex; i < n; i++) {
            vec.push_back(i + 1);
            dfs(results, vec, n, k, i + 1);
            vec.pop_back();
        }
    }
};
