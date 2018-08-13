class Solution {
public:
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    vector<vector<int>> subsets(vector<int> &nums) {
        // write your code here
        vector<vector<int>> res;
        vector<int> vec;
        sort(nums.begin(), nums.end());
        helper(res, vec, nums, 0);
        return res;
    }
private:
    void helper(vector<vector<int> > &res, vector<int> &vec, vector<int> &nums, int &index) {
        res.push_back(vec);
        for (int i = index; i < nums.size(); i++) {
            vec.push_back(nums[i]);
            helper(res, vec, nums, i + 1);
            vec.pop_back();
        }
    }
};
