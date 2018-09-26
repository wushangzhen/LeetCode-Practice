public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int adv = prices[i] - min;
            if (adv > result) {
                result = adv;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return result;
    }
}
