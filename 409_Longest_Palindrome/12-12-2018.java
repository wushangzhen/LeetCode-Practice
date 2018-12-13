class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] memo = new int[256];
        for (char c : s.toCharArray()) {
            memo[c]++;
        }
        int ans = 0;
        for (int a : memo) {
            ans += a / 2 * 2;
            if (ans % 2 == 0 && a % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }
}
