class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] max = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            max[i] = prices[i];
            if (i != n - 1) {
                max[i] = Math.max(max[i], max[i + 1]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, max[i] - prices[i]);
        }
        return res;
    }
}
