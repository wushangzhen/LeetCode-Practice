class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double left = 0; 
        double right = 1e8;
        while (left + 10e-6 < right) {
            double mid = left + (right - left) / 2;
            if (helper(mid, stations, K)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
    boolean helper(double mid, int[] stations, int K) {
        int cnt = 0;
        for (int i = 0; i < stations.length; i++) {
            if (i != 0) {
                cnt += (stations[i] - stations[i - 1]) / mid;
            }
        }
        return cnt <= K;
    }
}
