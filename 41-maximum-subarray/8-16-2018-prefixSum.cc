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
        int prefixSum = 0;
        int min = 0;
        int max = INT_MIN;
        for (int i = 0; i < nums.size(); i++) {
            prefixSum = prefixSum + nums[i];
            max = std::max(prefixSum - min, max);
            min = std::min(min, prefixSum);
        }
        return max;
    }
};
