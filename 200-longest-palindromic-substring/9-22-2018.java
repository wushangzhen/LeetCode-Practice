public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return null;
        }
        int len = s.length();
        int longest = Integer.MIN_VALUE;
        char[] sc = s.toCharArray();
        int start = 0;
        int n = 0;
        for (int i = 0; i < len; i++) {
            n = findPalindrome(sc, i, i);
            if (n > longest) {
                longest = n;
                start = i - n / 2;
            }
            n = findPalindrome(sc, i, i + 1);
            if (n > longest) {
                longest = n;
                start = i - n / 2 + 1;
            }
        }
        return s.substring(start, start + longest);
    }
    public int findPalindrome(char[] sc, int left, int right) {
        int len = 0;
        while (left >= 0 && right < sc.length) {
            if (sc[left] != sc[right]) {
                break;
            }
            len += left == right ? 1 : 2;
            left--;
            right++;
        }
        return len;
    }  
}
