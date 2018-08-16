class Solution {
public:
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    int maxSubArray(vector<int> &nums) {
        // write your code here
        if (nums.empty()) {
            return 0;
        }
        int sum = 0, max = INT_MIN;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            max = std::max(sum, max);
            sum = std::max(sum, 0);
        }
        return max;
    }
};
