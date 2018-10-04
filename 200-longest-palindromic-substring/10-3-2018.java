public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return "";
        }
        String result = "";
        char[] sc = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String str1 = find(i, i, sc, s);
            String str2 = find(i, i + 1, sc, s);
            if (str1.length() > str2.length()) {
                result = result.length() < str1.length() ? str1 : result;
            } else {
                result = result.length() < str2.length() ? str2 : result;
            }
        }
        return result;
    }
    String find(int left, int right, char[] sc, String s) {
        String str = "";
        while (left >= 0 && right < s.length() && sc[left] == sc[right]) {
            str = s.substring(left, right + 1);
            left--;
            right++;
        }
        return str;
    }
}
