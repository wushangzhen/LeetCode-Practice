class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int n = A.length;
        int[] dp = new int[n];
        int[] path = new int[n];
        int[] l = new int[n]; // update length to cover the edge cases of lexi order
        Arrays.fill(path, -1);
        dp[0] = A[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (A[i] == -1) {
                continue;
            }
            for (int j = 1; j <= B && i - j >= 0; j++) {
                if (dp[i - j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (dp[i - j] < dp[i] || (dp[i - j] == dp[i] && l[i] <= l[i - j] + 1)) {
                    path[i] = i - j;
                    dp[i] = dp[i - j];
                    l[i] = l[i - j] + 1;
                }
            }
            if (dp[i] != Integer.MAX_VALUE)
                dp[i] += A[i];
        }
        List<Integer> res = new LinkedList<>();
        if (dp[n - 1] == Integer.MAX_VALUE) {
            return res;
        }
        int prev = path[n - 1];
        res.add(n);
        if (prev < 0) {
            return res;
        }
        while (prev != 0) {
            res.add(0, prev + 1);
            prev = path[prev];
        }
        res.add(0, 1);
        return res;
    }
}
