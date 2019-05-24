class Solution {
    public String encode(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                String substr = s.substring(i, j + 1);
                dp[i][j] = substr;
                if (l < 4) {
                    continue;
                } else {
                    for (int k = i; k < j; k++) {
                        if ((dp[i][k] + dp[k + 1][j]).length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                    for (int k = 0; k < substr.length(); k++) {
                        String repeatStr = substr.substring(0, k + 1);
                        if (substr.length() % repeatStr.length() == 0
                           && substr.replaceAll(repeatStr, "").length() == 0) {
                            String ss = substr.length() / repeatStr.length() + "[" + dp[i][i + k] + "]";
                            if (ss.length() < dp[i][j].length()) {
                                dp[i][j] = ss;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
