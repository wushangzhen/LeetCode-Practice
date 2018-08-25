class Solution {
public:
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    vector<int> intersection(vector<int> &nums1, vector<int> &nums2) {
        // write your code here
        vector<int> result;
        if (nums1.empty() || nums2.empty()) {
            return result;
        }
        sort(nums1.begin(), nums1.end());
        set<int> hashSet;
        for (int i = 0; i < nums2.size(); i++) {
            if (hashSet.find(nums2[i]) != hashSet.end()) {
                continue;
            }
            if (binarySearch(nums1, nums2[i])) {
                hashSet.insert(nums2[i]);
            }
        }
        for (auto i : hashSet) {
            result.push_back(i);
        }
        return result;
    }
    bool binarySearch(vector<int>& num, int value) {
        int start = 0;
        int end = num.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] == value) {
                return true;
            } else if (num[mid] < value) {
                start = mid;
            } else {
                end = mid;
            }
        } 
        if (num[start] == value || num[end] == value) {
            return true;
        }
        return false;
    }
};
