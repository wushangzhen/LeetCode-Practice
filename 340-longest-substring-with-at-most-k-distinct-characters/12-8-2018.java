class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int n = s.length();
        char[] sc = s.toCharArray();
        int count = 0;
        int max = 0;
        int[] memo = new int[256];
        int start = 0;
        int end = 0;
        while (right < n) {
            if (memo[sc[right]] == 0) {
                count++;
            }
            memo[sc[right++]]--;
            if (count <= k) {
                if (right - left > max) {
                    end = right;
                    start = left;
                }
                max = Math.max(right - left, max);
            }
            while (count > k) {
                if (memo[sc[left]] == -1) {
                    count--;
                }
                memo[sc[left++]]++;
            }
        }
        System.out.println(s.substring(start, end));
        return max;
    }
}
