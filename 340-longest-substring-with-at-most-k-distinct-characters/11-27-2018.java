class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        int[] memo = new int[256];
        int left = 0;
        int right = 0;
        char[] sc = s.toCharArray();
        int max = 0;
        int count = 0;
        int n = s.length();
        while (right < n) {
            if (memo[sc[right]] == 0) {
                count++;
            }
            memo[sc[right]]--;
            right++;
            if (count <= k) {
                max = Math.max(max, right - left);
            }
            while (count > k) {
                if (memo[sc[left]] == -1) {
                    count--;
                }
                memo[sc[left]]++;
                left++;
            }
        }
        return max;
    }
}
