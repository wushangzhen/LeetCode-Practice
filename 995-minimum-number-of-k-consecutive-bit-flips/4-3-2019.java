class Solution {
    public int minKBitFlips(int[] A, int K) {
        int ans = 0;
        int n = A.length;
        int[] hint = new int[n];
        int flip = 0;
        for (int i = 0; i < n; i++) {
            flip ^= hint[i];
            if (flip == A[i]) {
                ans++;
                if (i + K > n) {
                    return -1;
                }
                flip ^= 1;
                if (i + K < n) {
                    hint[i + K] ^= 1;
                }
            }
        }
        return ans;
    }
}
