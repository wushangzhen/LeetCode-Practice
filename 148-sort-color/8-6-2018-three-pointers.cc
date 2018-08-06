class Solution {
public:
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    void sortColors(vector<int> &nums) {
        // write your code here
        if (nums.empty()) {
            return;
        }
        int pl = 0;
        int pr = nums.size() - 1;
        int i = 0;
        while (i <= pr) {
            if (nums[i] == 0) {
                swap(nums, pl, i);
                pl++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, pr);
                pr--;
            }
        }
    }
};
