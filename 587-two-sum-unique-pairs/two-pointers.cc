class Solution {
public:
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    int twoSum6(vector<int> &nums, int target) {
        // write your code here
        if (nums.empty()) {
            return 0;
        }
        sort(nums.begin(), nums.end());
        unordered_set<int> hashSet;
        int left = 0;
        int right = nums.size() - 1;
        int count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) { 
                if (hashSet.find(nums[left]) == hashSet.end()) {
                    count++;
                    hashSet.insert(nums[left]);
                }
                left++;
                right--;
            }
            if (sum > target) {
                right--;
                
            }
            if (sum < target) {
                left++;
            }
        }
        return count;
    }
};
