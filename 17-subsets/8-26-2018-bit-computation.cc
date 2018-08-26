class Solution {
public:
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    vector<vector<int>> subsets(vector<int> &nums) {
        // write your code here
        int n = nums.size();
        vector<vector<int>> results;
        vector<int> vec;
        if (n == 0) {
            results.push_back(vec);
            return results;
        }
        sort(nums.begin(), nums.end());
        for (int i = 0; i < (1 << n); i++) {
            helper(i, results, nums);
        }
        return results;
    }
    void helper(int num, vector<vector<int>>& results, vector<int>& nums) {
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            if ((num & (1 << i)) != 0) {
                result.push_back(nums[i]);
            }
        }
        results.push_back(result);
    }
};
