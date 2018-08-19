class Solution {
public:
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    int partitionArray(vector<int> &nums, int k) {
        // write your code here
        if (nums.empty()) {
            return 0;
        }
        int start = 0;
        int end = nums.size() - 1;
        while (start < end) {
            while (start < end && nums[start] < k) {
                start++;
            }
            while (start < end && nums[end] >= k) {
                end--; 
            }
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        return start;
        //for (int i = 0; i < nums.size(); i++) {
        //    if (nums[i] >= k) {
        //        return i;
        //    }
        //}
        //return nums.size();
    }
};
