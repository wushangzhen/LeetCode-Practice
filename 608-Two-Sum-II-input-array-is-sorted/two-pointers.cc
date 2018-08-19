class Solution {
public:
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    vector<int> twoSum(vector<int> &nums, int target) {
        // write your code here
        vector<int> result;
        int left = 0;
        int right = nums.size() - 1;
        while (right > left) {
            if (nums[left] + nums[right] == target) {
                result.push_back(left + 1);
                result.push_back(right + 1);
                break;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
};
