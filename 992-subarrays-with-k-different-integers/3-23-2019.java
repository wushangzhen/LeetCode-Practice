class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMost(A, K) - atMost(A, K - 1);
    }
    int atMost(int[] A, int K) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        int i = 0;
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0) {
                K--;
            }
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) {
                    K++;
                }
                i++;
            }
            res += j - i + 1;
            // the total number of subarrays ending at j that contain at most K distinct.
        }
        return res;
    }
}
