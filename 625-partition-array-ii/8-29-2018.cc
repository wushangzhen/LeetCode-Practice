class Solution {
public:
    /**
     * @param nums: an integer array
     * @param low: An integer
     * @param high: An integer
     * @return: nothing
     */
    void partition2(vector<int> &nums, int low, int high) {
        // write your code here
        if (nums.empty()) {
            return;
        }
        int left = 0;
        int right = nums.size() - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] > high) {
               int temp = nums[right]; 
               nums[right] = nums[i];
               nums[i] = temp;
               right--;
               i--;
            } else if (nums[i] < low) {
               int temp = nums[left]; 
               nums[left] = nums[i];
               nums[i] = temp;
               left++;
            }
        }
    }
};
