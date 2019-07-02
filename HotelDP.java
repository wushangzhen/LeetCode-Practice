class HotelDP {
    public int dp(int[] hotels) {
        int n = hotels.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; hotels[i] - hotels[j] <= 200 && j >= 1; j--) {
               dp[i] = Math.min(dp[i], dp[j] + cost(hotels[i - 1] - hotels[j - 1]));
            }
        }
        return dp[n];
    }
    public int cost(int x) {
        return (200 - x) ^ 2;
    }
        
}
