class Solution {
    int[] sums;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        if (n == 1) {
            return piles[0];
        }
        sums = new int[n];
        sums[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sums[i] = sums[i + 1] + piles[i];
        }
        Map<String, Integer> memo = new HashMap<>();
        return helper(0, 1, memo, piles);
    }
    int helper(int start, int M, Map<String, Integer> memo, int[] piles) {
        if (start == piles.length) {
            return 0;
        }
        String str = "" + start + " " + M;
        if (memo.containsKey(str)) {
            return memo.get(str);
        }
        int min = Integer.MAX_VALUE;
        for (int len = 1; len <= 2 * M; len++) {
            if (start + len > piles.length) {
                break;
            }
            min = Math.min(min, helper(start + len, Math.max(M, len), memo, piles));
        }
        int res = sums[start] - min;
        memo.put(str, res);
        return res;
    }
}
