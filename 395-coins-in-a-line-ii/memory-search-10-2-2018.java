public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int[] dp = new int[values.length + 1];
        boolean[] flag = new boolean[values.length + 1];
        int sum = 0;
        for (int now : values) {
            sum += now;
        }
        return sum < 2 * memorySearch(values.length, dp, flag, values);
    }
    int memorySearch(int n, int[] dp, boolean[] flag, int[] values) {
        if (flag[n] == true) {
            return dp[n];
        }
        flag[n] = true;
        if (n == 0) {
            dp[n] = 0;
        } else if (n == 1) {
            dp[n] = values[values.length - 1]; // one left person can most grab
        } else if (n == 2) {
            dp[n] = values[values.length - 1] + values[values.length - 2];
        } else if (n == 3) {
            dp[n] = values[values.length - 2] + values[values.length - 3];
        } else {
            dp[n] = Math.max(Math.min(memorySearch(n - 2, dp, flag, values), 
                memorySearch(n - 3, dp, flag, values)) + values[values.length - n],
                Math.min(memorySearch(n - 3, dp, flag, values), memorySearch(n - 4, dp, flag, values)) 
                + values[values.length - n] + values[values.length - n + 1]);
        }
        return dp[n];
    }
}
