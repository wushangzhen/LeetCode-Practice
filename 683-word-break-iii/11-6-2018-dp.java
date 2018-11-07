public class Solution {
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        Set<String> set = new HashSet<>();
        int max = 0;
        for (String str : dict) {
            set.add(str.toLowerCase());
            max = Math.max(str.length(), max);
        }
        s = s.toLowerCase();
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j <= max && i >= j; j++) {
                if (dp[i - j] == 0) {
                    continue;
                }
                String str = s.substring(i - j, i);
                if (set.contains(str)) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }
}
