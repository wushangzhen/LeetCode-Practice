class Solution {
public:
    /**
     * @param A: An integer array
     * @return: An integer
     */
    int singleNumber(vector<int> &A) {
        // write your code here
        for (int i = 1; i < A.size(); i++) {
            A[0] ^= A[i];
        }
        return A[0];
    }
};
