class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] memo = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            memo[i][0] = 1;
        }
        for (int j = 1; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1] + memo[i - 1][j];
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
        return memo[n][m];
    }
}
