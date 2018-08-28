class Solution {
public:
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    int twoSum5(vector<int> &nums, int target) {
        // write your code here
        if (nums.empty()) {
            return 0;
        }
        sort(nums.begin(), nums.end());
        int left = 0;
        int right = nums.size() - 1;
        int result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else {
                result += right-left;
                left++;
            }
        }
        return result;
    }
};
