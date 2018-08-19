class Solution {
public:
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    void moveZeroes(vector<int> &nums) {
        // write your code here
        int left = 0, right = 0;
        while (right < nums.size()) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        
    }
    void swap(vector<int> &vec, int start, int end) {
        int temp = vec[start];
        vec[start] = vec[end];
        vec[end] = temp;
    }
};
