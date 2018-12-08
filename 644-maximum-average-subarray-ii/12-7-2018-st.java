class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double l = -1e12;
        double r = 1e12;
        double eps = 1e-5;
        while (l + 1e-5 < r) {
            double mid = (l + r) / 2;
            if (check(mid, nums, k)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }
    boolean check(double mid, int[] nums, int k) {
        double[] sum = new double[nums.length + 1];
        double[] min_pre = new double[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + (nums[i - 1] - mid);
            if (i >= k && sum[i] - min_pre[i - k] > 0) {
                return true;
            }
            min_pre[i] = Math.min(min_pre[i - 1], sum[i]);
        }
        return false;
    }
}
