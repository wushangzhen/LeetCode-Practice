class Solution {
public:
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    int deduplication(vector<int> &nums) {
        // write your code here
        if (nums.empty()) {
            return 0;
        }
        sort(nums.begin(), nums.end());
        int len = nums.size();
        int left = 0, right = 0; 
        while (right < len) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                nums[left + 1] = nums[right];
                left++;
                right++;
            }
        }
        return left + 1;
    }
};
