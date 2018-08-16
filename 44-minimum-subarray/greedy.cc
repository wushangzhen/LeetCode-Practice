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
        int sum = 0;
        int min = INT_MAX;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            min = std::min(sum, min);
            sum = std::min(sum, 0);
        }
        return min;
    }
};
