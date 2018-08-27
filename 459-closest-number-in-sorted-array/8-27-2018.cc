class Solution {
public:
    /**
     * @param A: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    int closestNumber(vector<int> &A, int target) {
        // write your code here
        if (A.empty()) {
            return -1;
        }
        int start = 0;
        int end = A.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return abs(A[start] - target) < abs(A[end] - target) ? start : end;
    }
};
