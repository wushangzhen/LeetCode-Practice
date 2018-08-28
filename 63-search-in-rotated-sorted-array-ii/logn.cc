class Solution {
public:
    /**
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean 
     */
    bool search(vector<int> &A, int target) {
        // write your code here
        if (A.empty()) {
            return false;
        }
        int start = 0;
        int end = A.size() - 1;
        int lastElem = A[end];
        if (target == lastElem) {
            return true;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[mid] < target) {
                if (target > lastElem && A[mid] < lastElem) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (A[mid] > target) {
                if (target < lastElem && A[mid] > lastElem) {
                    start = mid;
                } else {
                end = mid;
                }
            }
        }
        if (A[start] == target || A[end] == target) {
            return true;
        }
        return false;
    }
};
