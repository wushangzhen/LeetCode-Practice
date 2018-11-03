class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(prices[i], min);
            if (i != 0)
                left[i] = Math.max(prices[i] - min, left[i - 1]);
        }
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(prices[i], max);
            if (i != n - 1)
                right[i] = Math.max(max - prices[i], right[i + 1]);
        }
        max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(left[i] + right[i], max);
        }
        return max;
        
    }
}
