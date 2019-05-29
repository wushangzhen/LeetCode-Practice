class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n]; // count
        int[] dp2 = new int[n]; // len
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (dp2[j] + 1 == dp2[i]) {
                        dp1[i] += dp1[j];
                    } else if (dp2[j] + 1 > dp2[i]) {
                        dp1[i] = dp1[j];
                        dp2[i] = dp2[j] + 1;
                    }
                }
            }
            max = Math.max(dp2[i], max);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp2[i] == max) {
                res += dp1[i];
            }
        }
        return res;
    }
}
