class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[1] = cost[0];
        dp[2] = cost[1];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i - 1];
        }
        return Math.min(dp[n - 1], dp[n]);
    }
}



class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int f1 = cost[0];
        int f2 = cost[1];
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = Math.min(f2, f1) + cost[i - 1];
            f1 = f2;
            f2 = f3;
        }
        return Math.min(f3, f1);
    }
}
