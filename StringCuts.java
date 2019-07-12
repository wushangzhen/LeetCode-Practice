class StringCuts {
    public int Solution(int[] cuts, int n) {
        int m = cuts.length;
        Integer[][] memo = new Integer[n][n];
        // we may have to sort the cuts to reduce the time complexity
        Arrays.sort(cuts);
        return helper(0, n - 1, 0, m - 1, cuts, memo);
    }
    public int helper(int start, int end, int p1, int p2, int[] cuts, Integer[][] memo) {
        if (start >= end) {
            return 1; // base case length = 1, the value == 1
        }
        if (p1 == p2) {
            return end - start + 1;
        }
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        int value = end - start + 1;
        int min = Integer.MAX_VALUE;
        for (int i = p1; i <= p2 ; i++) {
            if (start < cuts[i] && cuts[i] < end) { // should not be equal
                int left = helper(start, cuts[i], p1, i - 1, cuts, memo);
                int right = helper(cuts[i] + 1, end, p2, i + 1, cuts, memo);
                min = Math.min(min, left + right + value); 
            } 
        }
        memo[start][end] = min;
        return min;
    }
}
