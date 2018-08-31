class Solution {
public:
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    int twoSumClosest(vector<int> &nums, int target) {
        // write your code here
        if (nums.empty()) {
            return target;
        }
        sort(nums.begin(), nums.end());
        int left = 0; 
        int right = nums.size() - 1;
        int min = INT_MAX;
        while (left < right) {
            int sum = nums[left] + nums[right];
            min = std::min(abs(target - sum), min);
            if (target < sum) {
                right--;
            } else {
                left++;
            }
        }
        return min;
    }
};
