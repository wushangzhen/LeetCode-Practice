class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        MAX = float('inf');
        dp = [0] + [MAX] * amount
        for i in xrange(1, amount + 1):
            dp[i] = min([dp[i - c] if i - c >= 0 else MAX for c in coins]) + 1
        return [dp[amount], -1][dp[amount] == MAX]
        
