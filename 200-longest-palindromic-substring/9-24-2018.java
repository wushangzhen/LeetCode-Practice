public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        String result = "";
        if (s == null || s.length() == 0) {
            return result;
        }
        int n = s.length();
        char[] sc = s.toCharArray();
        for (int i = 0; i < n; i++) {
            String str = findPalindrom(i, i, sc, s);
            if (result.length() < str.length()) {
                result = str;
            }
            str = findPalindrom(i, i + 1, sc, s);
            if (result.length() < str.length()) {
                result = str;
            }
        }
        return result;
    }
    
    String findPalindrom(int left, int right, char[] sc, String s) {
        String str = "";
        while (left >= 0 && right < s.length()) {
            if (sc[left] == sc[right]) {
                str = s.substring(left, right + 1);
                left--;
                right++;
            } else {
                break;
            }
        }
        return str;
    }
}
