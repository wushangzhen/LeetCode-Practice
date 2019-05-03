class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n = A.length;
        int[] LarrL = new int[n];
        int[] MarrL = new int[n];
        int Lsum = 0;
        int LsumMax = 0;
        int Msum = 0;
        int MsumMax = 0;
        for (int i = 0; i < n; i++) {
            if (i < L - 1) {
                Lsum += A[i];
            } else {
                Lsum += A[i];
                LsumMax = Math.max(LsumMax, Lsum);
                LarrL[i] = LsumMax;
                Lsum -= A[i - L + 1];
            }
            if (i < M - 1) {
                Msum += A[i];
            } else {
                Msum += A[i];
                MsumMax = Math.max(MsumMax, Msum);
                MarrL[i] = MsumMax;
                Msum -= A[i - M + 1];
            }
        }
        int sum = 0;
        Msum = 0;
        MsumMax = 0;
        Lsum = 0;
        LsumMax = 0;
        for (int i = n - 1; i >= L - 1; i--) {
            if (i >= n - M) {
                Msum += A[i];
            } else {
                MsumMax = Math.max(MsumMax, Msum);
                sum = Math.max(sum, LarrL[i] + MsumMax);
                Msum += A[i] - A[i + M];
            }
        }
        for (int i = n - 1; i >= M - 1; i--) {
            if (i >= n - L) {
                Lsum += A[i];
            } else {
                LsumMax = Math.max(LsumMax, Lsum);
                sum = Math.max(sum, MarrL[i] + LsumMax);
                Lsum += A[i] - A[i + L];
            }
        }
        return sum;
    }
}
