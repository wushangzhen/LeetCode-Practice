class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int[] leftPos = new int[n];
        int[] rightPos = new int[n];
        int tot = 0;
        for (int i = k; i <= n; i++) {
            if (sum[i] - sum[i - k] > tot) {
                leftPos[i - 1] = i - k;
                tot = sum[i] - sum[i - k];
            } else {
                leftPos[i - 1] = leftPos[i - 2];
            }
        }
        tot = 0;
        for (int i = n - k; i > 0; i--) {
            if (sum[i + k] - sum[i] >= tot) {
                rightPos[i] = i;
                tot = sum[i + k] - sum[i];
            } else {
                rightPos[i] = rightPos[i + 1];
            }
        }
        int[] res = new int[3];
        int max = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int l = leftPos[i - 1];
            int r = rightPos[i + k];
            if (sum[l + k] - sum[l] + sum[i + k] - sum[i] + sum[r + k] - sum[r] > max) {
                max = sum[l + k] - sum[l] + sum[i + k] - sum[i] + sum[r + k] - sum[r];
                res = new int[]{l, i, r};
            }
        }
        return res;
    }
}
