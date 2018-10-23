public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        int[] memo = new int[256];
        char[] sc = s.toCharArray();
        for (char c : sc) {
            memo[c]++; 
        }
        for (int i = 0; i < memo.length; i++) {
            ans += memo[i] / 2 * 2;
            if (ans % 2 == 0 && memo[i] % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }
}
