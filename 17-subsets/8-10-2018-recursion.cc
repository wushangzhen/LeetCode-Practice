class Solution {
public:
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    vector<vector<int>> subsets(vector<int> &nums) {
        // write your code here
        vector<vector<int> > res_vec;
        vector<int> vec;
        sort(nums.begin(), nums.end());
        dfs(nums, 0, vec, res_vec);
        return res_vec;
    }
    void dfs(vector<int> &nums, 
             int index, 
             vector<int> &vec, 
             vector<vector<int> > &vec_res) {
        if (index == nums.size()) {
            vec_res.push_back(vec);
            return;
        }
        vec.push_back(nums[index]);
        dfs(nums, index + 1, vec, vec_res);
        vec.pop_back();
        dfs(nums, index + 1, vec, vec_res);
    }
};
