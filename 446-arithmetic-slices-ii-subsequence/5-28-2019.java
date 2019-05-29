class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        Map<Integer, Integer>[] dp = new Map[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long d = (long)A[i] - A[j];
                if (d <= Integer.MIN_VALUE || d > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int) d;
                int c1 = dp[i].getOrDefault(diff, 0);
                int c2 = dp[j].getOrDefault(diff, 0);
                res += c2;
                dp[i].put(diff, c1 + c2 + 1);
            }
        }
        return res;
    }
}
