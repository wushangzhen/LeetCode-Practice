class Solution {
    // "abcabcbb"
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 1;
        int n = s.length();
        int[] memo = new int[256];
        char[] sc = s.toCharArray();
        while (right < n) {
            while (memo[sc[right]] < 0) {
                memo[sc[left++]]++;
            }
            memo[sc[right++]]--;
            max = Math.max(right - left, max);
        }
        return max;
    }
}
