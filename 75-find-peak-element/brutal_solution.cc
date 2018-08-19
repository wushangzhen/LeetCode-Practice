class Solution {
public:
    /*
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    int findPeak(vector<int>& A) {
        // write your code here
        int start = 1;
        int startNext = start + 1;
        int end = A.size() - 2;
        int endNext = end - 1;
        while (endNext >= 0 && startNext < A.size() && endNext > startNext) {
            if (A[endNext] < A[end]) {
                return end;
            }
            if (A[startNext] < A[start]) {
                return start;
            }
            endNext--;
            end--;
            start++;
            startNext++;
        }
        return end;
    }
};
