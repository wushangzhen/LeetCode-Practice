class Solution {
public:
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    int findMin(vector<int> &nums) {
        // write your code here
        if (nums.size() == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.size() - 1;
        while (start + 1 < nums.size() && end - 1 >= 0 && end > start) {
            if (nums[start + 1] < nums[start]) {
                return nums[start + 1];
            }
            if (nums[end - 1] > nums[end]) {
                return nums[end];
            }
            end--;
            start++;
        }
        return nums[0];
    }
};
