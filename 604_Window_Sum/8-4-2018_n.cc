class Solution {
public:
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    vector<int> winSum(vector<int> &nums, int k) {
        // write your code here
        vector<int> res_vec;
        if (nums.empty()) {
            return res_vec;
        }
        int start = 0; 
        int end = start + k - 1;
        int sum = 0;
        for (int i = start; i < end; i++) {
           sum += nums[i]; 
        }
        res_vec.push_back(sum);
        while (end < nums.size()) {
            sum -= nums[start];
            start++;
            end++;
            sum += nums[end];
            res_vec.push_back(sum);            
        }
    }
};
