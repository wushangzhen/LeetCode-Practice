class Solution {
public:
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    vector<vector<int>> combinationSum(vector<int> &candidates, int target) {
        // write your code here
        vector<vector<int>> results;
        vector<int> vec;
        if (candidates.empty()) {
            return results;
        }
        sort(candidates.begin(), candidates.end());
        dfs(results, vec, candidates, 0, target);
        return results;
    }
    void dfs(vector<vector<int>>& results, 
             vector<int>& vec, 
             vector<int>& candidates, 
             int startindex,
             int target) {
                 
        if (target == 0) {
            results.push_back(vec);
            return;
        }             
        for (int i = startindex; i < candidates.size(); i++) {
            if (i != startindex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            vec.push_back(candidates[i]);
            dfs(results, vec, candidates, i, target - candidates[i]);
            vec.pop_back();
        }
    }
};
