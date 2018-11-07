public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if ((s == null || s.length() == 0) && dict.size() == 0) {
            return true;
        }
        int max = getMax(dict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= max && i - j >= 0; j++) {
                if (!dp[i - j]) {
                    continue;
                }
                String str = s.substring(i - j, i);
                if (dict.contains(str)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    
    int getMax(Set<String> dict) {
        int max = 0;
        for (String str : dict) {
            max = Math.max(str.length(), max);
        }
        return max;
    }
}
