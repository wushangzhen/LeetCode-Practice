class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            if (i != 0 && prices[i] > prices[i - 1]) {
                max += (prices[i] - prices[i - 1]);
            }
        }
        return max;
    }
}
