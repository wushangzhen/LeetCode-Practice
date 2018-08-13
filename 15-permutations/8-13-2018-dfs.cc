class Solution {
public:
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    vector<vector<int>> permute(vector<int> &nums) {
        // write your code here
        vector<vector<int> > results;
        vector<int> vec;
        bool* visit_ptr = new bool[nums.size()];
        memset(visit_ptr, false, sizeof(visit_ptr)); // initialize the array in case of different compliers
        dfs(results, nums, visit_ptr, vec);
        return results;
    }
private:
    void dfs(vector<vector<int>> &results, 
             vector<int> &nums, 
             bool* visit_ptr, 
             vector<int> &vec) {
        if (vec.size() == nums.size()) {
            results.push_back(vec);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (visit_ptr[i]) {
                continue;
            }
            
            vec.push_back(nums[i]);
            visit_ptr[i] = true;
            dfs(results, nums, visit_ptr, vec);
            vec.pop_back();
            visit_ptr[i] = false;
        }
             
    }
};
