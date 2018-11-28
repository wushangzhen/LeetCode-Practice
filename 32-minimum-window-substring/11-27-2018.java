class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] memo = new int[256];
        for (char c : tc) {
            memo[c]++;
        }
        int left = 0;
        int right = 0;
        int n = s.length();
        int m = t.length();
        int count = m;
        int start = -1;
        int len = Integer.MAX_VALUE;
        while (right < n) {
            while (right < n && count != 0) {
                if (memo[sc[right]] > 0) {
                    count--;
                }
                memo[sc[right]]--;
                right++;
            }
            while (count == 0) {
                if (len > right - left) {
                    start = left;
                    len = right - left;
                }
                if (memo[sc[left]] >= 0) {
                    count++;
                }
                memo[sc[left]]++;
                left++;
            }
        }
        return start == -1 ? "" : s.substring(start, start + len);
    }
}
