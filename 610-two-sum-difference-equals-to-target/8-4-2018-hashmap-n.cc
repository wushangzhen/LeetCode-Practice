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
        for (int i = 0; i < nums.size(); i++) {
            int tmp = nums[i] - target;
            if (un_map.find(tmp) != un_map.end()) {
                res_vec.push_back(un_map[tmp] + 1);
                res_vec.push_back(i + 1);
                return res_vec;
            }
            tmp = nums[i] + target;
            if (un_map.find(tmp) != un_map.end()) {
                res_vec.push_back(un_map[tmp] + 1);
                res_vec.push_back(i + 1);
                return res_vec;
            }
            un_map[nums[i]] = i;
        }
    }
};
