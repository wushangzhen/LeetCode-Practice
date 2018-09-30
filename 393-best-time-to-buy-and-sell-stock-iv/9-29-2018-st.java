public class Solution {
    /**
     * @param K: An integer
     * @param prices: An integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        // write your code here
        if (k == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int n = prices.length;
        int[][] mustSell = new int[n + 1][n + 1]; // 
        int[][] globalBest = new int[n + 1][n + 1];
        mustSell[0][0] = globalBest[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            mustSell[0][i] = globalBest[0][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            int gainOrLose = prices[i] - prices[i - 1];
            mustSell[i][0] = 0;
            for (int j = 1; j <= k; j++) {
                mustSell[i][j] = Math.max(globalBest[i - 1][j - 1] + gainOrLose, 
                    mustSell[i - 1][j] + gainOrLose); 
                globalBest[i][j] = Math.max(globalBest[i - 1][j], mustSell[i][j]);
            }
        }
        return globalBest[n - 1][k];
    }
}
