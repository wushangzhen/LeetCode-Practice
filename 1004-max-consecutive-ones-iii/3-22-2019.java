class Solution {
    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        int n = A.length;
        while (right < n) {
            if (A[right] == 1) {
                right++;
                continue;
            } else if (K > 0) {
                right++;
                K--;
                continue;
            } else {
                max = Math.max(right - left, max);
                while (K == 0) {
                    if (A[left] == 0) {
                        K++;
                    } 
                    left++;
                }
            }
        }
        max = Math.max(right - left, max);
        return max;
    }
}
