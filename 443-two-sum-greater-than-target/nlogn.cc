class Solution {
public:
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    int twoSum2(vector<int> &nums, int target) {
        // write your code here
        if (nums.empty()) {
            return 0;
        }
        int left = 0;
        int right = nums.size() - 1;
        int count = 0;
        sort(nums.begin(), nums.end());
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) {
                left++;
            } else {
                count = count + right - left;
                right--;
            }
        }
        return count;
    }
};
