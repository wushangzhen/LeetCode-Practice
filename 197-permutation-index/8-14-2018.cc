class Solution {
public:
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    long long permutationIndex(vector<int> &A) {
        // write your code here
        long long result = 0;
        int len = A.size();
        for (int i = len - 1; i >= 0; i--) {
            long long count = 0;
            for (int j = len - 1; j > i; j--) {
                if (A[j] < A[i]) {
                    count++;
                }
            }
            result += (count * factorial(len - i - 1));
        }
        return result + 1;
    }
private:
    long long factorial(int i) {
        long long result = 1;
        for (int j = i; j > 0; j--) {
            result *= j;
        }
        return result;
    }
};
