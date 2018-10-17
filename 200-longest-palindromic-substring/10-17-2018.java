class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        char[] sc = s.toCharArray();
        int len = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = find(i, i, sc);
            int len2 = find(i, i + 1, sc);
            if (len1 > len2) {
                if (len < len1) {
                    len = len1;
                    start = i - (len1 / 2);
                    end = i + (len1 / 2);
                }
            } else {
                if (len < len2) {
                    len = len2;
                    start = i + 1 - len2 / 2;
                    end = i + len2 / 2;
                }
            }
        }
        return s.substring(start, end + 1);
    }
        
        
    int find(int start, int end, char[] sc) {
        int len = 0;
        while (start >= 0 && end < sc.length && sc[start] == sc[end]) {
            len = end - start + 1;
            start--;
            end++;
        }
        return len;
    }
}
