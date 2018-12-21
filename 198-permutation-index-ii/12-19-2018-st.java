public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndexII(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0L;
        }
        Map<Integer, Integer> count = new HashMap<>();
        long index = 1, fact = 1, multiFact = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (count.containsKey(A[i])) {
                count.put(A[i], count.get(A[i]) + 1);
                multiFact *= count.get(A[i]);
            } else {
                count.put(A[i], 1);
            }
            int rank = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    rank++;
                }
            }
            index += rank * fact / multiFact;
            fact *= (A.length - i);
        }
        return index;
    }
}
