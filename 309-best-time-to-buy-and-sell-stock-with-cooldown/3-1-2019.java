class Solution {
    // buy[i] means before day i what is the maxProfit for any sequence end with buy.
    // sell[i] means before day i what is the maxProfit for any sequence end with sell.
    // rest[i] means before day i what is the maxProfit for any sequence end with rest.
    
    // rest[i] = Math.max(sell[i - 1], rest[i - 1])
    // buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i - 1])
    // sell[i] = Math.max(buy[i - 1] + prices[i - 1], sell[i - 1])
    // sell[i] >= rest[i] sell always got the highest profit
    // rest[i] = sell[i - 1]
    
    /*
        buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i - 1])
        sell[i] = Math.max(buy[i - 1] + prices[i - 1], sell[i - 1])
    */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] buy = new int[n + 1];
        int[] sell = new int[n + 1];
        buy[0] = 0;
        sell[0] = 0;
        sell[1] = 0;
        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i - 1]);
            } else {
                buy[i] = -prices[i - 1];
                continue;
            }
            sell[i] = Math.max(buy[i - 1] + prices[i - 1], sell[i - 1]);
        }
        return sell[n];
    }
}
