class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        double l = 0;
        double r = 1;
        int[] res = new int[2];
        while (l + 1e-9 < r) {
            double mid = l + (r - l) / 2;
            double[] temp = helper(mid, A, K);
            if (temp[0] < K) {
                l = mid;
            } else {
                res[0] = (int)temp[1];
                res[1] = (int)temp[2];
                r = mid;
            }
        }
        return res;
    }
    double[] helper(double mid, int[] A, int K) {
        int a = 0, b = 1, i = -1, count = 0;
        for (int j = 0; j < A.length; j++) {
            while (i + 1 < j && A[i + 1] < A[j] * mid) {
                i++;
            }
            count += i + 1;
            if (0 <= i && a * A[j] < b * A[i]) {
                a = A[i];
                b = A[j];
            }
        }
        return new double[]{(double)count, (double)a, (double)b};
    }
}
