class Solution {
public:
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    vector<int> subarraySum(vector<int> &nums) {
        // write your code here
        vector<int> result;
        //if (nums.empty()) {
        //    return result;
        //}
        unordered_map<int, int> hashMap;
        int prefixSum = 0;
        for (int i = 0; i < nums.size(); ++i) {
            hashMap[prefixSum] = i;
            prefixSum += nums[i];
            if (hashMap.find(prefixSum) != hashMap.end()) {
                result.push_back(hashMap[prefixSum]);
                result.push_back(i);
                break;
            } 
        }
        return result;
    }
};
