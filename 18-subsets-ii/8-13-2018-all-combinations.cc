class Solution {
public:
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    vector<vector<int>> subsetsWithDup(vector<int> &nums) {
        // write your code here
        vector<vector<int>> results;
        vector<int> vec;
        sort(nums.begin(), nums.end());
        helper(results, nums, 0, vec);
        return results;
    }
    void helper(vector<vector<int>> &results, 
                vector<int> &nums, 
                int index, 
                vector<int> &vec) {
                    
        results.push_back(vec);
        for (int i = index; i < nums.size(); i++) {
            if (i != 0 && nums[i] == nums[i - 1] && i > index) { // i > index prevent that duplicate numbers
                continue;
            }
            vec.push_back(nums[i]);
            helper(results, nums, i + 1, vec);
            vec.pop_back();
        }
    }
};
