class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.sort(pairs, (a, b)->(a[1]-b[1])); // sort the array first so that we can get the longest one
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
