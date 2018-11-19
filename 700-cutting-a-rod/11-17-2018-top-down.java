public class Solution {
    /**
     * @param prices: the prices
     * @param n: the length of rod
     * @return: the max value
     */
    Map<Integer, Integer> hash = new HashMap<>();
    public int cutting(int[] prices, int n) {
        // Write your code here
        if (hash.containsKey(n)) {
            return hash.get(n);
        }
        if (n == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, cutting(prices, i) + prices[n - i - 1]);
        }
        hash.put(n, res);
        return res;
    }
}
