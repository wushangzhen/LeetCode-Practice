class Solution {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[1];
        }
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            int n = (i & (i - 1));
            dp[i] = dp[n] + 1;
        }
        return dp;
    }
}
