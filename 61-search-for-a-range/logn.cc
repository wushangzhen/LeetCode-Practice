class Solution {
public:
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    vector<int> searchRange(vector<int> &A, int target) {
        // write your code here
        vector<int> result;
        if (A.empty()) {
            result.push_back(-1);
            result.push_back(-1);
            return result;
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
        int first = -1;
        if (A[start] == target) {
            first = start;
        } else if (A[end] == target) {
            first  = end;
        }
        start = 0; 
        end = A.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int second = -1;
        if (A[end] == target) {
            second = end;
        } else if (A[start] == target) {
            second = start;
        }
        result.push_back(first);
        result.push_back(second);
        return result;
    }
};
