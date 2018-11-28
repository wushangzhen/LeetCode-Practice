class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        char[] sc = s.toCharArray();
        int[] memo = new int[256];
        int count = 0;
        while (right < n) {
            if (memo[sc[right]] == 0) {
                count++;
            }
            memo[sc[right]]--;
            right++;
            if (count <= 2) {
                max = Math.max(max, right - left);
            }
            while (count > 2) {
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
