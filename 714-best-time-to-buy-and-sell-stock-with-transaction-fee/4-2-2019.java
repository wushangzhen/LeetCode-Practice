class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0; // represent we do not have stock 
        int hold = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
