class Solution {
    public int minDeletionSize(String[] A) {
        int n = A.length;
        int m = A[0].length();
        int k = 0;
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                // judgement for every word to see if they are all meet the requirement
                for (k = 0; k < n; k++) {
                    if (A[k].charAt(j) > A[k].charAt(i)) {
                        break;
                    }
                }
                // increasing subsequence
                if (k == n && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            res = Math.min(res, m - dp[i]);
        }
        return res;
    }
}
