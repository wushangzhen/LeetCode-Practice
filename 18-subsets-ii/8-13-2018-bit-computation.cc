class Solution {
public:
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    vector<vector<int>> subsetsWithDup(vector<int> &nums) {
        // write your code here
        int len = nums.size();
        vector<vector<int> > results;

        for (int i = 0; i < (1 << len); i++) {
            vector<int> vec;
            for (int j = 0; j < len; j++) {
                if (i & (1 << j)) {
                    vec.push_back(nums[j]);
                }
            } 
            results.push_back(vec);
        }
        return results;
    }
};
