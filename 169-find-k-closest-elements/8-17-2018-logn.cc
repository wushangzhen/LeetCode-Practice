class Solution {
public:
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    vector<int> kClosestNumbers(vector<int> &A, int target, int k) {
        // write your code here
        vector<int> result;
        if (A.empty()) {
            return result;
        }
        int start = 0;
        int end = A.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        while (result.size() < k) {
            if (start < 0 || end < A.size() && std::abs(A[end] - target) < std::abs(A[start] - target)) {
                result.push_back(A[end]);
                end++;
            } else {
                result.push_back(A[start]);
                start--;
            }
        }
        return result;
    }
};
