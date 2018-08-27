class Solution {
public:
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    int totalOccurrence(vector<int> &A, int target) {
        // write your code here
        if (A.empty()) {
            return 0;
        }
        if (target < A[0] || target > A[A.size() - 1]) {
            return 0;
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
        int count = 0;
        if (A[start] == target) {
            while (A[start++] == target) {
                count++;
            }
        } else {
            while (A[end++] == target) {
                count++;
            }
        }
        return count;
    }
};
