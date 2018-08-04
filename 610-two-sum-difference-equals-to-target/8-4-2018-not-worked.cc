class Solution {
public:
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    vector<int> twoSum7(vector<int> &nums, int target) {
        // write your code here
        vector<int> res_vec;
        unordered_map<int, int> un_map;
        int len = nums.size();
        for (int i = 0; i < len; i++) {
            un_map[i] = nums[i]; // override the old value
        }
        sort(nums.begin(), nums.end());
        target = abs(target);
        int start = 0;
        int end = 1;
        for (; start < len; start++) {
            while (end < len && nums[end] - nums[start] < target) {
                end++;
            }
            if (nums[end] - nums[start] == target && end != start) {
                if (un_map[nums[start]] < un_map[nums[end]]) {
                    res_vec.push_back(un_map[nums[start]] + 1);
                    res_vec.push_back(un_map[nums[end]] + 1);
                } else {
                    res_vec.push_back(un_map[nums[end]] + 1);
                    res_vec.push_back(un_map[nums[start]] + 1);
                }
            }
        }
        return res_vec;
};
