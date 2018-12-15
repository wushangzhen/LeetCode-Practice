class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double l = -1e12;
        double r = 1e12;
        while (l + 1e-5 < r) {
            double mid = (l + r) / 2;
            if (check(nums, mid, k)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }
    boolean check(int[] nums, double mid, int k) {
        int n = nums.length;
        double[] sum = new double[n + 1];
        double min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (nums[i - 1] - mid);
            if (i >= k) {
                min = Math.min(min, sum[i - k]);
                if (sum[i] - min >= 0) {
                    return true;
                }
            }
        }
        return false;
    }
    
}
