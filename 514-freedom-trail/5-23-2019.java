class Solution {
    public int findRotateSteps(String ring, String key) {
        int m = key.length();
        int n = ring.length();
        int[][] dp = new int[m + 1][n]; // dp[i][j] After i possible rotation ends with pointing j, How many operation need next;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) { // list all possible original point direction
                if (i == 0 || ring.charAt(j) == key.charAt(i - 1)) { // pruning, no need to try all possible direction only those meet key requirement
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < n; k++) { // traverse all possible value
                        if (key.charAt(i) == ring.charAt(k)) {
                            int diff = Math.abs(k - j);
                            int step = Math.min(n - diff, diff);
                            dp[i][j] = Math.min(dp[i][j], dp[i + 1][k] + step);
                        }
                    }
                    if (i == 0) {
                        break; // only compute j == 0
                    }
                }
            }
        }
        return dp[0][0] + m;
    }
}
