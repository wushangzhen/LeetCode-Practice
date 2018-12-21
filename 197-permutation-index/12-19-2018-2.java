public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        long result = 1;
        int len = A.length;
        long fact = 1;
        for (int i = len - 1; i >= 0; i--) {
            int count = 0;
            for (int j = len - 1; j > i; j--) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
            result += count * fact;
            fact *= A.length - i;
        }
        return result;
    }
}
