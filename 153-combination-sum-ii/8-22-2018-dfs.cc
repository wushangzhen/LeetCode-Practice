class Solution {
public:
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    vector<vector<int>> combinationSum2(vector<int> &num, int target) {
        // write your code here
        vector<vector<int>> results;
        vector<int> vec;
        if (num.empty()) {
            return results;
        }
        sort(num.begin(), num.end());
        dfs(results, num, target, 0, 0, vec);
        return results;
    }
    void dfs(vector<vector<int>>& results, vector<int>& num, int target, int startIndex, int sum, vector<int>& vec) {
        if (target == 0) {
            results.push_back(vec);
            return;
        }
        if (startIndex == num.size()) {
            return;
        }
        for (int i = startIndex; i < num.size(); i++) {
            if ((num[i] + sum) > target) {
                break;
            }
            if (i != startIndex && num[i] == num[i - 1]) {
                continue;
            }
            if ((num[i] + sum) < target) {
                vec.push_back(num[i]);
                sum = num[i] + sum;
                dfs(results, num, target, i + 1, sum, vec);
                vec.pop_back();
                sum -= num[i];
            } 
            if ((num[i] + sum) == target) {
                vec.push_back(num[i]);
                sum = num[i] + sum;
                results.push_back(vec);
                vec.pop_back();
                sum -= num[i];
            }
        }
    }
};
