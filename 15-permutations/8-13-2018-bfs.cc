class Solution {
public:
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    vector<vector<int>> permute(vector<int> &nums) {
        // write your code here
        queue<vector<int>> que;
        vector<vector<int>> results;
        vector<int> vec;
        que.push(vec);
        while (!que.empty()) {
            vector<int> vecTemp = que.front();
            que.pop();
            if (vecTemp.size() == nums.size()) {
                results.push_back(vecTemp);
                continue;
            }
            for (int i = 0; i < nums.size(); i++) {
                vec = vecTemp;
                if (find(vec.begin(), vec.end(), nums[i]) == vec.end()) {
                    vec.push_back(nums[i]);
                    que.push(vec);
                }
            }
        }
        return results;       
    }
};
