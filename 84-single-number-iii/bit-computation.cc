class Solution {
public:
    /**
     * @param A: An integer array
     * @return: An integer array
     */
    vector<int> singleNumberIII(vector<int> &A) {
        // write your code here
        vector<int> result(2, 0);
        int diff = 0;;
        for (auto a : A) {
            diff ^= a;
        }
        int firstOne = diff & (-diff);
        for (int i = 0; i < A.size(); i++) {
            if ((A[i] & firstOne) != 0) { // pay attention the symbol's priority
                result[0] ^= A[i];
            } else {
                result[1] ^= A[i];
            }
        }
        return result;
    }
};
