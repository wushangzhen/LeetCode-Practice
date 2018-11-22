class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] sc = s.toCharArray();
        int[] memo = new int[256];
        int n = s.length();
        int right = 0;
        int left = 0;
        int max = 1;
        while (right < n) {
            while (right < n && memo[sc[right]] != -1) {
                memo[sc[right]] = -1;
                right++;
            }
            max = Math.max(max, right - left);
            while (right < n && memo[sc[right]] == -1) {
                memo[sc[left]]++;
                left++;
            }
        }
        return max;
    }
}
