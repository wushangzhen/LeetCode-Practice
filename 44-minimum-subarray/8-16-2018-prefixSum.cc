class Solution {
public:
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    int minSubArray(vector<int> &nums) {
        // write your code here
        if (nums.empty()) {
            return 0;
        }
        int prefixSum = 0; 
        int max = 0;
        int min = INT_MAX;
        for (int i = 0; i < nums.size(); i++) {
            prefixSum += nums[i];
            min = std::min(prefixSum - max, min);
            max = std::max(prefixSum, max);
        }
        return min;
    }
};
