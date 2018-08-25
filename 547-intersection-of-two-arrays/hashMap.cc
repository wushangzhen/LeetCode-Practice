class Solution {
public:
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    vector<int> intersection(vector<int> &nums1, vector<int> &nums2) {
        // write your code here
        unordered_set<int> hashMap;
        vector<int> result;
        if (nums1.empty() || nums2.empty()) {
            return result;
        }
        for (int i : nums1) {
            hashMap.insert(i);
        }
        unordered_set<int> resultHash;
        for (int i : nums2) {
            if (hashMap.find(i) != hashMap.end()) {
                if (resultHash.find(i) == resultHash.end()) {
                    result.push_back(i);
                    resultHash.insert(i);
                }
            }
        }
        sort(result.begin(), result.end());
        return result;
    }
};
