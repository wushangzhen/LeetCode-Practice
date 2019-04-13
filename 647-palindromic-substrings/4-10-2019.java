class Solution {
    int res = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(i, i, s);
            extendPalindrome(i, i + 1, s);
        }
        return res;
    }
    void extendPalindrome(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            res++;
        }
    } 
}
