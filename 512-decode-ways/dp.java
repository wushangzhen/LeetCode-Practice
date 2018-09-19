public class Solution {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        char[] cArray = s.toCharArray();
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (cArray[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            if (i >= 2) {
                int val = 0;
                val = cArray[i - 2] - '0';
                val = 10 * val + (cArray[i - 1] - '0');
                if (val <= 26 && val >= 10) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }
}


